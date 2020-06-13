package com.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.banking.utils.DatabaseUtil;

public class UserDao
{
	DatabaseUtil util = new DatabaseUtil();
	
	
	public Map<String,String> validate(String uname, String pass) throws SQLException 
	{
		Map<String,String>  userDetails = new HashMap<String, String>();
		String userRole=null;
		Connection con = util.getConnection();
		System.out.println(con);
		
		
		String userValidationQuery = "select * from USER where USER_NAME=? and PASSWORD =?";
		
		PreparedStatement st = con.prepareStatement(userValidationQuery);
		st.setString(1, uname);
		st.setString(2, pass);

		
		
		ResultSet rs = st.executeQuery();  
		
		if (rs.next())
		{
			String userId = rs.getString("USER_ID");
			String roleId = rs.getString("ROLE_ID");
			
			String checkUserRoleQuery = "select ROLE from ROLE where ROLE_ID=?";
			
			st = con.prepareStatement(checkUserRoleQuery);
			st.setString(1,roleId);
			rs = st.executeQuery();
			rs.next();
			userRole=rs.getString(1);
			userDetails.put("userId", userId);
			userDetails.put("userRole", userRole);
			util.closeConnection();

			
			
			return userDetails;
		}
		
		return userDetails;
			
			
			
		
		
	}
	
}
