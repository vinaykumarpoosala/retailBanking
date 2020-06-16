package com.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.banking.beans.Account;
import com.banking.beans.Customer;
import com.banking.beans.CustomerStatus;
import com.banking.utils.DatabaseUtil;

public class UserDao {
	DatabaseUtil util = new DatabaseUtil();
	ResultSet rs = null;
	PreparedStatement st = null;

	Connection con = null;

	public Map<String, String> validate(String uname, String pass) throws SQLException {
		Map<String, String> userDetails = new HashMap<String, String>();
		String userRole = null;
		Connection con = util.getConnection();
		System.out.println(con);

		String userValidationQuery = "select * from USER where USER_NAME=? and PASSWORD =?";

		PreparedStatement st = con.prepareStatement(userValidationQuery);
		st.setString(1, uname);
		st.setString(2, pass);

		ResultSet rs = st.executeQuery();

		if (rs.next()) {
			String userId = rs.getString("USER_ID");
			String roleId = rs.getString("ROLE_ID");

			String checkUserRoleQuery = "select ROLE from ROLE where ROLE_ID=?";

			st = con.prepareStatement(checkUserRoleQuery);
			st.setString(1, roleId);
			rs = st.executeQuery();
			rs.next();
			userRole = rs.getString(1);
			userDetails.put("userId", userId);
			userDetails.put("userRole", userRole);
			util.closeConnection();

			return userDetails;
		}

		return userDetails;

	}

	public String addCustomer(Customer newCustomer, String token) throws SQLException {
		String customerId = "";

		try {
			Connection con = util.getConnection();

			String customerInsertionQuery = "INSERT INTO CUSTOMER(SSNID,CUSTOMER_NAME,CUSTOMER_ADRESS,AGE,STATE,CITY) VALUES(?,?,?,?,?,?)";

			PreparedStatement st = con.prepareStatement(customerInsertionQuery, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, newCustomer.getSsnid());
			st.setString(2, newCustomer.getCustomername());
			st.setString(3, newCustomer.getAddress());
			st.setInt(4, newCustomer.getAge());
			st.setString(5, newCustomer.getState());
			st.setString(6, newCustomer.getCity());

			int insertedRowCount = st.executeUpdate();

			if (insertedRowCount > 0) {
				String query = "select CUSTOMER_ID from customer order by customer_id desc limit 1";
				st = con.prepareStatement(query);
				rs = st.executeQuery();
				System.out.println(rs);
				if (rs.next())
					customerId = rs.getString("CUSTOMER_ID");
				System.out.println(customerId);

				if (customerId != null) {

					System.out.println(customerId);
					// after inserting update USER_CUSTOMER TABLE

					String userCustomerTableQuery = "INSERT INTO USER_CUSTOMER VALUES(?,?)";
					st = con.prepareStatement(userCustomerTableQuery);
					st.setString(1, token);
					st.setString(2, customerId);
					st.executeUpdate();

					String status = "ACTIVE";
					String message = "Customer Created successfully";
					String customerLogsQuery = "INSERT INTO CUSTOMER_LOGS VALUES(?,?,?,?,CURRENT_TIMESTAMP)";

					// inserting into customer-logs and passing params
					st = con.prepareStatement(customerLogsQuery);
					st.setString(1, customerId);
					st.setString(2, newCustomer.getSsnid());
					st.setString(3, status);
					st.setString(4, message);
					System.out.println(customerLogsQuery);

					st.executeUpdate();
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.closeConnection();

		}

		return customerId;
	}

	public Customer searchCustomerBasedOnCustomerId(String customer_Id) throws SQLException {
		Customer customer = null;

		try {
			con = util.getConnection();
			String searchQuery = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = ?";

			st = con.prepareStatement(searchQuery);
			st.setString(1, customer_Id);

			rs = st.executeQuery();
			if (rs.next()) {
				// CUSTOMER_NAME

				// CUSTOMER_ID
				String customerId = rs.getString("CUSTOMER_ID");
				String ssnid = rs.getString("SSNID");
				String customername = rs.getString("CUSTOMER_NAME");
				String customerAddress = rs.getString("CUSTOMER_ADRESS");
				int age = rs.getInt("AGE");
				String state = rs.getString("STATE");
				String city = rs.getString("CITY");
				customer = new Customer();
				customer.setAddress(customerAddress);
				customer.setAge(age);
				customer.setCity(city);
				customer.setCustomerId(customerId);
				customer.setCustomername(customername);
				customer.setSsnid(ssnid);
				customer.setState(state);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.closeConnection();
		}

		return customer;

	}

	public Customer searchCustomerBasedOnSSNID(String SSNID) throws SQLException {
		Customer customer = null;
		try {
			con = util.getConnection();
			String searchQuery = "SELECT * FROM CUSTOMER WHERE SSNID = ?";
			st = con.prepareStatement(searchQuery);
			st.setString(1, SSNID);
			rs = st.executeQuery();
			if (rs.next()) {
				// CUSTOMER_NAME

				// CUSTOMER_ID
				String customerId = rs.getString("CUSTOMER_ID");
				String ssnid = rs.getString("SSNID");
				String customername = rs.getString("CUSTOMER_NAME");
				String customerAddress = rs.getString("CUSTOMER_ADRESS");
				int age = rs.getInt("AGE");
				String state = rs.getString("STATE");
				String city = rs.getString("CITY");
				customer = new Customer();
				customer.setAddress(customerAddress);
				customer.setAge(age);
				customer.setCity(city);
				customer.setCustomerId(customerId);
				customer.setCustomername(customername);
				customer.setSsnid(ssnid);
				customer.setState(state);

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.closeConnection();
		}
		System.out.println(customer);

		return customer;
	}

	public boolean deleteCustomer(String customerId) throws SQLException {
		boolean isdeleted = true;
		try {

			System.out.println(customerId);
			con = util.getConnection();
			String deleteCustomerLogs = "DELETE FROM CUSTOMER_LOGS WHERE CUSTOMER_ID = ?";
			String deleteUserCustomer = "DELETE FROM USER_CUSTOMER WHERE CUSTOMER_ID = ?";
			String deleteQuery = "DELETE FROM CUSTOMER WHERE CUSTOMER_ID = ?";
			st = con.prepareStatement(deleteCustomerLogs);
			st.setString(1, customerId);
			st.execute();
			st = con.prepareStatement(deleteUserCustomer);
			st.setString(1, customerId);
			st.execute();
			st = con.prepareStatement(deleteQuery);
			st.setString(1, customerId);
			isdeleted = st.execute();
			System.out.println(isdeleted);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.closeConnection();
		}

		return isdeleted;
	}

	public boolean updateCustomer(Customer cust) throws SQLException {
		boolean isUpdated = false;
		try {
			con = util.getConnection();

			System.out.println(cust);
			String updateQuery = "UPDATE CUSTOMER SET CUSTOMER_NAME = ? , CUSTOMER_ADRESS = ? ,AGE = ? WHERE CUSTOMER_ID = ?";
			st = con.prepareStatement(updateQuery);
			st.setString(1, cust.getCustomername());
			st.setString(2, cust.getAddress());
			st.setInt(3, cust.getAge());
			st.setString(4, cust.getCustomerId());
			int rowsEffected = st.executeUpdate();
			if (rowsEffected > 0) {
				String updateCustomerStatus = "UPDATE CUSTOMER_LOGS SET MESSAGE = 'customer updated successfully' , STATUS = 'active' ,LAST_UPDATED = CURRENT_TIMESTAMP WHERE CUSTOMER_ID=? ";
				st = con.prepareStatement(updateCustomerStatus);
				st.setString(1, cust.getCustomerId());
				st.execute();
				isUpdated = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.closeConnection();
		}

		return isUpdated;
	}

	@SuppressWarnings("null")
	public List<CustomerStatus> findCustomerStatus() throws SQLException {
		List<CustomerStatus> listOfCustomerStatus = new ArrayList<CustomerStatus>();
		CustomerStatus custStatus = null;
		con = util.getConnection();

		try {

			String SearchAllCustomerStatusQuery = "SELECT * FROM CUSTOMER_LOGS ";
			PreparedStatement st = con.prepareStatement(SearchAllCustomerStatusQuery);
			ResultSet rs = st.executeQuery();
			System.out.println(rs);
			while (rs.next()) {

				// CustomerStatus(String customerId, String ssnid, String status, String
				// message, String lastUpdated)
				custStatus = new CustomerStatus(rs.getString("CUSTOMER_ID"), rs.getString("SSNID"),
						rs.getString("STATUS"), rs.getString("MESSAGE"), rs.getTimestamp("LAST_UPDATED").toString());
				System.out.println(custStatus);
				listOfCustomerStatus.add(custStatus);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.closeConnection();
		}
		return listOfCustomerStatus;
	}

	public String addAccount(Account account) {
		String accountId = "";

		try {
			Connection con = util.getConnection();
			String searchQuery = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = ?";

			st = con.prepareStatement(searchQuery);
			System.out.println(account.getCustomerId());
			st.setString(1, account.getCustomerId());
			boolean rowsEffected = st.execute();
			System.out.println(rowsEffected);
			System.out.println();
			if (rowsEffected) {
				System.out.println("IN IF");

				
				String checkForSpecifiedAccountWithAccountType = "SELECT * FROM ACCOUNT_LOGS WHERE CUSTOMER_ID =? and ACCOUNT_TYPE = ?";
				st = con.prepareStatement(checkForSpecifiedAccountWithAccountType);
				st.setString(1, account.getCustomerId());
				st.setString(2, account.getAccountType());
				rs = st.executeQuery();
				System.out.println(rs);
				if (!rs.next()) {
					
					System.out.println("in if of rs.next");

					String customerInsertionQuery = "INSERT INTO ACCOUNTS(ACCOUNTS_TYPE) VALUES(?)";

					PreparedStatement st = con.prepareStatement(customerInsertionQuery,
							Statement.RETURN_GENERATED_KEYS);

					st.setString(1, account.getAccountType().toLowerCase());

					int insertedRowCount = st.executeUpdate();
					System.out.println(insertedRowCount);
					if (insertedRowCount > 0) {
						String query = "select ACCOUNT_ID from ACCOUNTS order by ACCOUNT_ID desc limit 1";
						st = con.prepareStatement(query);
						rs = st.executeQuery();
						System.out.println(rs);
						if (rs.next())
							accountId = rs.getString("ACCOUNT_ID");

						System.out.println(accountId);

						if (accountId != null || accountId != "") {

							String depositQuery = "INSERT INTO ACCOUNT_BALANCE(ACCOUNT_ID,BALANCE) VALUES(?,?)";
							st = con.prepareStatement(depositQuery);
							st.setString(1, accountId);
							st.setLong(2, account.getDeposit());
							st.executeUpdate();

							System.out.println(accountId);
							// after inserting update ACCOUNT_CUSTOMER TABLE

							String userCustomerTableQuery = "INSERT INTO ACCOUNT_CUSTOMER VALUES(?,?)";
							st = con.prepareStatement(userCustomerTableQuery);
							st.setString(1, accountId);
							st.setString(2, account.getCustomerId());
							st.executeUpdate();

							String status = "ACTIVE";
							String message = "account Created successfully";
							String customerLogsQuery = "INSERT INTO ACCOUNT_LOGS VALUES(?,?,?,?,?,CURRENT_TIMESTAMP)";

							// inserting into customer-logs and passing params
							st = con.prepareStatement(customerLogsQuery);
							st.setString(1, account.getCustomerId());
							st.setString(2, accountId);
							st.setString(3, account.getAccountType());
							st.setString(4, status);
							st.setString(5, message);
							System.out.println(customerLogsQuery);

							st.execute();
						}

					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("in finally bloc");
			util.closeConnection();

		}

		return accountId;

	}

	public List<String> fetchAllCustomerIds() {

		List<String> listOfAccounts = new ArrayList<String>();
		String query = "select ACCOUNT_ID from ACCOUNTS";
		try {
			con = util.getConnection();

			rs = con.prepareStatement(query).executeQuery();

			while (rs.next()) {
				listOfAccounts.add(rs.getString("ACCOUNT_ID"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.closeConnection();
		}
		return listOfAccounts;
	}

	@SuppressWarnings("null")
	public boolean deleteAccount(String account_id, String account_type) {
		boolean isdeleted = true;

		try {
			System.out.println("in delete account");
			con = util.getConnection();
			String checkForSpecifiedAccountWithAccountType = "SELECT * FROM ACCOUNTS WHERE ACCOUNT_ID =? and ACCOUNTS_TYPE = ?";
			st = con.prepareStatement(checkForSpecifiedAccountWithAccountType);
			st.setString(1, account_id);
			st.setString(2, account_type);
			rs = st.executeQuery();
			System.out.println(rs);
			if (rs.next()) {
				System.out.println(account_id);

				String deleteaccountBalance = "DELETE FROM account_balance WHERE ACCOUNT_ID = ?";
				String deleteUserCustomer = "DELETE FROM ACCOUNT_CUSTOMER WHERE ACCOUNT_ID = ?";
				String deleteQuery = "DELETE FROM ACCOUNTS WHERE ACCOUNT_ID = ?";
				st = con.prepareStatement(deleteaccountBalance);
				st.setString(1, account_id);
				st.execute();
				st = con.prepareStatement(deleteUserCustomer);
				st.setString(1, account_id);
				st.execute();
				st = con.prepareStatement(deleteQuery);
				st.setString(1, account_id);
				isdeleted = st.execute();

				System.out.println(isdeleted);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.closeConnection();
		}

		return isdeleted;

	}

}
