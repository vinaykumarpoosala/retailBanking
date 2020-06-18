package com.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.banking.beans.Account;
import com.banking.beans.TransactionBean;
import com.banking.utils.DatabaseUtil;

public class TransactionDao {
	DatabaseUtil util = new DatabaseUtil();
	ResultSet rs = null;
	PreparedStatement st = null;

	Connection con = null;
	
	
	/**
	 * 
	 * @param customerId
	 * @return
	 */
	public List<Account> searchAccountBasedOnCustomerId(String customerId) {
		List<Account> accounts = new ArrayList<Account>();
		Account account = null;
		try {
			String accountId;
			String account_type;
			String customer_id;
			int balance;
			con = util.getConnection();
			String searchQuery = "SELECT * FROM TRANSACTION_VIEW WHERE CUSTOMER_ID = ?";
			st = con.prepareStatement(searchQuery);
			st.setString(1, customerId);
			rs = st.executeQuery();
			while (rs.next()) {

				accountId = rs.getString("ACCOUNT_ID");
				account_type = rs.getString("ACCOUNTS_TYPE");
				balance = rs.getInt("BALANCE");
				accounts.add(new Account(accountId, account_type, balance, customerId));
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("connection closing failed");
			}
		}
		System.out.println(account);

		return accounts;

	}

	// searchAccountBasedOnAccountId
	/**
	 * 
	 * @param aCCOUNT_ID
	 * @return
	 */
	public List<Account> searchAccountBasedOnAccountId(String aCCOUNT_ID) {
		List<Account> accounts = new ArrayList<Account>();
		Account account = null;
		try {

			String account_type;
			String customer_id;
			int balance;
			con = util.getConnection();
			String searchQuery = "SELECT * FROM TRANSACTION_VIEW WHERE ACCOUNT_ID = ?";
			st = con.prepareStatement(searchQuery);
			st.setString(1, aCCOUNT_ID);
			rs = st.executeQuery();

			if (rs.next()) {
				System.out.println("in loop");

				customer_id = rs.getString("CUSTOMER_ID");
				account_type = rs.getString("ACCOUNTS_TYPE");
				balance = rs.getInt("BALANCE");
				accounts.add(new Account(aCCOUNT_ID, account_type, balance, customer_id));
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("in account");
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("connection closing failed");
			}
		}
		System.out.println(account);

		return accounts;

	}
	
	/**
	 * 
	 * @param accountId
	 * @param depositAmount
	 * @param accountType
	 * @return
	 */

	public boolean depositMoney(String accountId, int depositAmount, String accountType) {
		boolean isDeposited = false;
		con = util.getConnection();
		try {

			String depositQuery = "UPDATE ACCOUNT_BALANCE SET BALANCE = BALANCE+? WHERE ACCOUNT_ID = ?";
			st = con.prepareStatement(depositQuery);
			st.setInt(1, depositAmount);
			st.setString(2, accountId);

			int i = st.executeUpdate();
			System.out.println(i);
			if (i > 0) {
				System.out.println("in if statement");
				String QueryForTransaction = "INSERT INTO TRANSACTIONS(ACCOUNT_ID,ACCOUNT_TYPE,AMOUNT,TRANSACTION_DATE,TRANSACTION_TYPE) VALUES(?,?,?,CURRENT_TIMESTAMP,'deposit')";

				st = con.prepareStatement(QueryForTransaction);
				st.setString(1, accountId);
				st.setString(2, accountType);
				st.setInt(3, depositAmount);
				isDeposited = st.execute();
			}

		}

		catch (Exception e) {

			System.out.println("error occuered");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("connection closing failed");

			}
		}

		return isDeposited;
	}
	
	
	/**
	 * 
	 * @param accountId
	 * @param withdrawAmount
	 * @param accountType
	 * @return
	 */

	public boolean withdrawMoney(String accountId, int withdrawAmount, String accountType) {
		boolean ismoneyWithdrawed = false;
		try {
			con = util.getConnection();
			String withdrawQuery = "UPDATE ACCOUNT_BALANCE SET BALANCE = BALANCE-? WHERE ACCOUNT_ID = ?";
			st = con.prepareStatement(withdrawQuery);
			st.setInt(1, withdrawAmount);
			st.setString(2, accountId);

			int i = st.executeUpdate();
			System.out.println(i);
			if (i > 0) {
				System.out.println("in if statement");
				String QueryForTransaction = "INSERT INTO TRANSACTIONS(ACCOUNT_ID,ACCOUNT_TYPE,AMOUNT,TRANSACTION_DATE,TRANSACTION_TYPE) VALUES(?,?,?,CURRENT_TIMESTAMP,'withdraw')";

				st = con.prepareStatement(QueryForTransaction);
				st.setString(1, accountId);
				st.setString(2, accountType);
				st.setInt(3, withdrawAmount);
				ismoneyWithdrawed = st.execute();
			}

		} catch (Exception e) {
			System.out.println("error occuered");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("connection closing failed");

			}
		}

		return ismoneyWithdrawed;

	}
	
	/**
	 * 
	 * @param accountId
	 * @return
	 * @throws SQLException
	 */

	public int getBalance(String accountId) throws SQLException {
		int balance = 0;
		con = util.getConnection();
		try {
			String query = "SELECT BALANCE FROM ACCOUNT_BALANCE WHERE ACCOUNT_ID=?";
			st = con.prepareStatement(query);
			st.setString(1, accountId);
			rs = st.executeQuery();
			if (rs.next())
				balance = rs.getInt("BALANCE");
			System.out.println("balance" + balance);
		} catch (Exception e) {
			System.out.println("excp");
		} finally {
			con.close();
		}
		return balance;
	}
	
	
	
	/**
	 * 
	 * @param customerId
	 * @param sourceAccountType
	 * @param targetaccountType
	 * @param transferAmount
	 * @return
	 */
	public boolean transferMoney(String customerId, String sourceAccountType, String targetaccountType,
			int transferAmount) {
		System.out.println("source account" + sourceAccountType);
		System.out.println("target account" + targetaccountType);
		System.out.println("money to transfer" + transferAmount);
		boolean isamountTransfered = true;
		try {
			List<Account> listOfAccounts = searchAccountBasedOnCustomerId(customerId);

			System.out.println(listOfAccounts);
			for (Account acc : listOfAccounts) {
				if (acc.getAccountType().equalsIgnoreCase(sourceAccountType)) {
					System.out.println("in if");
					System.out.println(getBalance(acc.getAccountId()));
					int accountBalance = getBalance(acc.getAccountId());
					
					if (accountBalance >= transferAmount) {
						System.out.println(acc.getAccountId() + "" + acc.getBalance() + "" + sourceAccountType);
						isamountTransfered = withdrawMoney(acc.getAccountId(), transferAmount, sourceAccountType);
						System.out.println("is amount tra " + isamountTransfered);
					}
				}

			}
			for (Account acc : listOfAccounts) {
				if (acc.getAccountType().equalsIgnoreCase(targetaccountType)) {
					if (!isamountTransfered) {
						System.out.println(acc.getAccountId() + " " + acc.getBalance() + " " + targetaccountType);
						isamountTransfered = depositMoney(acc.getAccountId(), transferAmount, targetaccountType);
					} 

				}
			}
		} catch (Exception e) {

		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return isamountTransfered;
	}
	
	
	

	/**
	 * 
	 * @param accountId
	 * @return
	 */
	public List<TransactionBean> getTransaction(String accountId) {

		List<TransactionBean> listOfTransaction = new ArrayList<TransactionBean>();

		
		try {

			// data baase connection
			con = util.getConnection();

			
			/*
			 * String TID; String account_id; String account_type; int amount; String
			 * transactionDate; String transactionType;
			 */
			String queryForTransactionsStatement = "SELECT * FROM TRANSACTIONS WHERE ACCOUNT_ID = ?";
			st = con.prepareStatement(queryForTransactionsStatement);
			
			st.setString(1, accountId);
			ResultSet rs2 = st.executeQuery();

			if (rs2.next()) {
				while (rs2.next()) {
					System.out.println("in while loop");
					String TID = rs2.getString("TID");
					String account_id = rs2.getString("ACCOUNT_ID");
					String accountType = rs2.getString("ACCOUNT_TYPE");
					int amount = rs2.getInt("AMOUNT");
					String transactionDate = rs2.getTimestamp("TRANSACTION_DATE").toString();
					String transactionType = rs2.getString("TRANSACTION_TYPE");
					TransactionBean transaction = new TransactionBean(TID, account_id, accountType, amount,
							transactionDate, transactionType);
					listOfTransaction.add(transaction);
					System.out.println(transaction);
				}
			}

		}
		catch (Exception e) {

		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listOfTransaction;
	}

}
