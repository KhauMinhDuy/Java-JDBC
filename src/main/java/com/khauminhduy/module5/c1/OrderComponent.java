package com.khauminhduy.module5.c1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class OrderComponent {

	private static final String URL = "jdbc:mysql://localhost:3306/classicmodels";
	private static final String USER = "root";
	private static final String PASS = "Aa123456!";
	
	public void updateOrderQunatity(int orderNumber, String productCode, int newQuantity) {
		String query = "UPDATE orderdetails SET quantityOrdered = ? WHERE orderNumber = ? AND productCode = ?";
		try(Connection connection = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setInt(1, newQuantity);
			preparedStatement.setInt(2, orderNumber);
			preparedStatement.setString(3, productCode);
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			
		}
	}
}
