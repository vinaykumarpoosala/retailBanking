package com.banking.services;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.banking.dao.UserDao;

public class UserService {
	UserDao dao = new UserDao();

	public Map<String,String> validate(String uname, String pass) throws SQLException 
	{
		
		Map<String,String> userDetails = new HashMap<String,String>();
		userDetails = dao.validate(uname,pass);
		
		return userDetails;
	}

}
