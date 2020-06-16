package com.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.banking.beans.Account;
import com.banking.utils.DatabaseUtil;

public class TransactionDao {
	DatabaseUtil util = new DatabaseUtil();
	ResultSet rs = null;
	PreparedStatement st = null;

	Connection con = null;

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
				System.out.println("in loop");

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

	public boolean depositMoney(String accountId, int depositAmount, String accountType) {
		boolean isDeposited = false;
		try {
			con = util.getConnection();
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

		} catch (Exception e) {
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

	public boolean transferMoney(String customerId, String sourceAccountType, String targetaccountType,
			int transferAmount) {
		boolean isamountTransfered = false;
		List<Account> listOfAccounts = searchAccountBasedOnCustomerId(customerId);
		for (Account acc : listOfAccounts) {
			if (acc.getAccountType().equalsIgnoreCase(sourceAccountType)) {
				isamountTransfered = withdrawMoney(acc.getAccountId(), transferAmount, sourceAccountType);
			} else {
				isamountTransfered = depositMoney(acc.getAccountId(), transferAmount, sourceAccountType);

			}
		}
		return isamountTransfered;
	}

}
