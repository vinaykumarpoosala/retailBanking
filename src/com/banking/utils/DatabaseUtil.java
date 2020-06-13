package com.banking.utils;

import java.sql.Connection;
import java.sql.DriverManager;


//this class is for making database connection


public class DatabaseUtil 
{
	Connection con=null;
	
	public Connection getConnection()
	{
		
		String url = "jdbc:mysql://localhost:3306/RETAIL_BANKING";
		String uname ="root";
		String password = "vinay@123";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,password);
		}
		catch(Exception e)
		{
			System.out.println("error occured");
		}
			
		return con;
		
	}
	
	public void closeConnection()
	{
		try
		{
			con.close();
		}catch(Exception e)
		{
			System.out.println("error occured while closing db connection object");
		}
	}
		
}
