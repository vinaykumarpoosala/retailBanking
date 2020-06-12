package com.util;

/**
 * conection to sqlite db class in util package
 * refer com.beans for details to access database columns
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Deepak
 *
 */
public class DbTransaction {

	public static final String DRIVERNAME = "org.sqlite.JDBC";
	public static final String URL = "jdbc:sqlite:C:/Users/deepa/MySQLiteDB";
	public static final String Table1 = "emplinfo";

	public static Connection getConnection() {
		Connection con = null;

		try {
			Class.forName(DRIVERNAME);
			con = DriverManager.getConnection(URL);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return con;
	}

}
