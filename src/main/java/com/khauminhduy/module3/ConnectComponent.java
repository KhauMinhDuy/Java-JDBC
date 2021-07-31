package com.khauminhduy.module3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectComponent {

	private static final String URL = "jdbc:mysql://localhost:3306/classicmodels";
	private static final String USER = "root";
	private static final String PASS = "Aa123456!";
	
	public boolean tryConnection() throws SQLException {
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		boolean valid = con.isValid(2);
		con.close();
		
		return valid;
		
	}
}
