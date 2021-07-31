package com.khauminhduy.module7.c2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderComponent_AC {

	private static final String URL = "jdbc:mysql://localhost:3306/classicmodels";
	private static final String USER = "root";
	private static final String PASS = "Aa123456!";
	
	public int createOrder(int customerNumber, LineItem lineItem) throws SQLException {
		try(Connection connection = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO orders "
						+ "(orderDate, requiredDate, status, customerNumber) " 
						+ "Values (now(), now(), 'In Process', ?)",
						Statement.RETURN_GENERATED_KEYS);) {
			
			connection.setAutoCommit(false);
			
			prepareStatement.setInt(1, customerNumber);
			prepareStatement.executeUpdate();
			
			try(ResultSet resultSet = prepareStatement.getGeneratedKeys();) {
				if(!resultSet.next()) {
					return 0;
				}
				int orderNumber = resultSet.getInt(1);
				
				String query = "INSERT INTO orderdetails "
						+ "(orderNumber, productCode, quantityOrdered, priceEach, orderLineNumber) "
						+ "VALUES (?, ?, ?, ?, ?)";
				
				try(PreparedStatement detailsPS = connection.prepareStatement(query);) {
					detailsPS.setInt(1, orderNumber);
					detailsPS.setString(2, lineItem.productCode);
					detailsPS.setInt(3, lineItem.quantityOrdered);
					detailsPS.setDouble(4, lineItem.priceEach);
					detailsPS.setDouble(5, 1);
					
					int executeUpdate = detailsPS.executeUpdate();
					
					if(executeUpdate == 1) {
						connection.commit();
						return orderNumber;
					} else {
						connection.rollback();
						return 0;
					}
					
				}
			}
		}
	}
}
