package com.khauminhduy.module4.preparedstm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductsComponent {

	private static final String URL = "jdbc:mysql://localhost:3306/classicmodels";
	private static final String USER = "root";
	private static final String PASS = "Aa123456!";

	public void printProductList() {
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement prepareStatement = con
						.prepareStatement("SELECT productName FROM products WHERE buyPrice BETWEEN ? AND ?");) {
			prepareStatement.setInt(1, 50);
			prepareStatement.setInt(2, 100);
			try(ResultSet resultSet = prepareStatement.executeQuery();) {
				while(resultSet.next()) { 
					String name = resultSet.getString("productName");
					System.out.println(name);
				}
			}
		} catch (Exception e) {
			System.out.println("SQLException message: " + e.getMessage());
			if (e instanceof SQLException) {
				SQLException sqlException = (SQLException) e;
				System.out.println("Error Code: " + sqlException.getErrorCode());
				System.out.println("SQL State: " + sqlException.getSQLState());
			}
		}

	}
}
