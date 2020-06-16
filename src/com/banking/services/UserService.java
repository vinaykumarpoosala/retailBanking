package com.banking.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.banking.beans.Account;
import com.banking.beans.Customer;
import com.banking.beans.CustomerStatus;
import com.banking.dao.UserDao;

public class UserService {
	UserDao dao = new UserDao();
	

	public Map<String,String> validate(String uname, String pass) throws SQLException 
	{
		
		Map<String,String> userDetails = new HashMap<String,String>();
		userDetails = dao.validate(uname,pass);
		
		return userDetails;
	}

	

	public String addCustomer(Customer newCustomer, String token) throws SQLException {
		
		return dao.addCustomer(newCustomer,token);
	}



	public Customer searchCustomer(Map<String, String> searchCreteria) throws SQLException 
	{
		Customer customer = null;
		System.out.println(searchCreteria.get("SSNID"));
		System.out.println(searchCreteria.get("customer_id"));
		if(searchCreteria.get("SSNID").trim().isEmpty())
		{
			
			customer = dao.searchCustomerBasedOnCustomerId(searchCreteria.get("customer_id"));

			
		}
		else
		{
			System.out.println("in else block");
			System.out.println(searchCreteria.get("SSNID"));
			customer = dao.searchCustomerBasedOnSSNID(searchCreteria.get("SSNID"));
		}
		System.out.println(customer);
		
		return customer;
	}



	public boolean deleteCustomer(String customerId) throws SQLException {
		boolean deleted = true;
		deleted = dao.deleteCustomer(customerId);
		return deleted;
		
	}



	public boolean updateCustomer(Customer cust) throws SQLException {
		boolean isUpdated = false;
		isUpdated = dao.updateCustomer(cust);
		return isUpdated;
	}



	public List<CustomerStatus> findCustomerStatus() throws SQLException {
		List<CustomerStatus> listOfCustomerStatus = null;
		
		listOfCustomerStatus = dao.findCustomerStatus();
		return listOfCustomerStatus;
	}



	public String addAccount(Account account) {
		String accountId = "";
		accountId  = dao.addAccount(account);
		return accountId;
	}



	public List<String> fetchAllCustomerIds() {
		List<String> listOfAccounts = new ArrayList<String>();
		listOfAccounts = dao.fetchAllCustomerIds();
		return listOfAccounts;
	}



	public Customer searchCustomerBasedOnSSN(String sSNID) throws SQLException {
		
		Customer customer = null;
		customer = dao.searchCustomerBasedOnSSNID(sSNID);
		
		return customer;
	}
	
	
public Customer searchCustomerBasedOnCustomerId(String customerId) throws SQLException {
		
		Customer customer = null;
		customer = dao.searchCustomerBasedOnCustomerId(customerId);
		
		return customer;
	}



public boolean deleteAccount(String account_id, String account_type) {
	boolean accountDeleted = true;
	accountDeleted = dao.deleteAccount(account_id,account_type);
	return accountDeleted;
}



public Account searchAccountBasedOnAccountId(String aCCOUNT_ID) {
	
	return null;
}



public Account searchAccountBasedOnCustomerId(String customerId) {
	// TODO Auto-generated method stub
	return null;
}

}
