package com.khauminhduy.module4.stm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductsComponent {

	private static final String URL = "jdbc:mysql://localhost:3306/classicmodels";
	private static final String USER = "root";
	private static final String PASS = "Aa123456!";

	public void printProductList() {
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				Statement statement = con.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT productName,quantityInStock,buyPrice FROM products");){
			while (resultSet.next()) {
				String productName = resultSet.getString("productName");
				int quantity = resultSet.getInt("quantityInStock");
				double price = resultSet.getDouble("buyPrice");
				System.out.format("%-45s %5d %10.2f%n", productName, quantity, price);
			}
		} catch (Exception e) {
			System.out.println("SQLException message: " + e.getMessage());
			if(e instanceof SQLException) {
				SQLException sqlException = (SQLException) e;
				System.out.println("Error Code: " + sqlException.getErrorCode());
				System.out.println("SQL State: " + sqlException.getSQLState());
			}
		}

	}
}
