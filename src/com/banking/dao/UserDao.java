package com.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.banking.beans.Customer;
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

				String status = "INACTIVE";
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
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			util.closeConnection();

		}

		return customerId;
	}
	
	public Customer searchCustomerBasedOnCustomerId(String customer_Id) throws SQLException
	{
		Customer customer = null;
		con = util.getConnection();		
		String searchQuery = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = ?";
		
		st = con.prepareStatement(searchQuery);
		st.setString(1, customer_Id);

		rs = st.executeQuery();
		if(rs.next())
		{
			//CUSTOMER_NAME
			
			//CUSTOMER_ID
			String customerId = rs.getString("CUSTOMER_ID");
			String ssnid = rs.getString("SSNID");
			String customername = rs.getString("CUSTOMER_NAME");
			String customerAddress = rs.getString("CUSTOMER_ADRESS");
			int age = rs.getInt("AGE");
			String state = rs.getString("STATE");
			String city = rs.getString("CITY");
			
			customer.setAddress(customerAddress);
			customer.setAge(age);
			customer.setCity(city);
			customer.setCustomerId(customerId);
			customer.setCustomername(customername);
			customer.setSsnid(ssnid);
			customer.setState(state);		
			
		}
		return customer;

		
	}

	public Customer searchCustomerBasedOnSSNID(String SSNID) throws SQLException {
		Customer customer = null;
		con = util.getConnection();		
		String searchQuery = "SELECT * FROM CUSTOMER WHERE SSNID = ?";
		st = con.prepareStatement(searchQuery);
		st.setString(1, SSNID);
		rs = st.executeQuery();
		if(rs.next())
		{
			//CUSTOMER_NAME
			
			//CUSTOMER_ID
			String customerId = rs.getString("CUSTOMER_ID");
			String ssnid = rs.getString("SSNID");
			String customername = rs.getString("CUSTOMER_NAME");
			String customerAddress = rs.getString("CUSTOMER_ADRESS");
			int age = rs.getInt("AGE");
			String state = rs.getString("STATE");
			String city = rs.getString("CITY");
			
			customer.setAddress(customerAddress);
			customer.setAge(age);
			customer.setCity(city);
			customer.setCustomerId(customerId);
			customer.setCustomername(customername);
			customer.setSsnid(ssnid);
			customer.setState(state);		
			
		}
		return customer;
	}

}
