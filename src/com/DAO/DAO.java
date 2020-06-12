package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.beans.emplinfo;
import com.util.DbTransaction;

public class DAO {
	public int addEmployee(emplinfo e) {
		int count = 0;

		try {
			Connection con = DbTransaction.getConnection();

			String query = "insert into emplinfo values(?,?)";

			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, e.getUsername());
			ps.setString(2, e.getPassword() );

			//return e.getId();

		} catch (SQLException err) {
			System.out.println(err);
		}
		return count;
	}

}
