package com.khauminhduy.module7.c1;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionPool {

	private static final String URL = "jdbc:mysql://localhost:3306/classicmodels";
	private static final String USER = "root";
	private static final String PASS = "Aa123456!";

	
	private static HikariDataSource dataSource;
	
	static {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(URL);
		config.setUsername(USER);
		config.setPassword(PASS);
		dataSource = new HikariDataSource(config);
		dataSource.setMaximumPoolSize(4);
	}
	
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

}
