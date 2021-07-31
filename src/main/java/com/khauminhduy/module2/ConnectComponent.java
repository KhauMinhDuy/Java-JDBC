package com.khauminhduy.module2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectComponent {

	private static final String URL = "jdbc:mysql://localhost:3306/classicmodels";
	private static final String USER = "root";
	private static final String PASS = "Aa123456!";
	
	public boolean getConnection() throws SQLException {
		 try(Connection connection = DriverManager.getConnection(URL, USER, PASS);) {
			 return connection.isValid(2);
		 }
	}
}
