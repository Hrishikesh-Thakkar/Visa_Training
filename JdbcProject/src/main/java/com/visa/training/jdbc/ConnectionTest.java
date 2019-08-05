package com.visa.training.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection c = JdbcUtil.getConnection();
		try {
			DatabaseMetaData metadata = c.getMetaData();
			System.out.println(metadata.getDatabaseProductName());
			System.out.println(metadata.getDatabaseProductVersion());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
