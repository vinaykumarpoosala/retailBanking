package com.banking.services;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.banking.beans.Customer;
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
		if(searchCreteria.get("SSNID")!=null || searchCreteria.get("SSNID") != "")
		{
			customer = dao.searchCustomerBasedOnSSNID(searchCreteria.get("SSNID"));
		}
		else
		{
			customer = dao.searchCustomerBasedOnCustomerId(searchCreteria.get("customer_id"));

		}
		
		return customer;
	}

}
