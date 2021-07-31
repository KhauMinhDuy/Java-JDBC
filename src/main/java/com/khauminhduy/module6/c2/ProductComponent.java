package com.khauminhduy.module6.c2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductComponent {

	private static final String URL = "jdbc:mysql://localhost:3306/classicmodels";
	private static final String USER = "root";
	private static final String PASS = "Aa123456!";

	public void listProductBy(String productLine) throws SQLException {
		try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
				CallableStatement callableStatement = connection.prepareCall("{ call listProductsFor(?) }");) {

			callableStatement.setString(1, productLine);
			boolean execute = callableStatement.execute();
			if (execute) {
				try (ResultSet resultSet = callableStatement.getResultSet();) {
					while (resultSet.next()) {
						String name = resultSet.getString("productName");
						System.out.println(name);
					}
				}
			}

		}

	}
	
	public String updateEmail(int employeeNumber, String newEmail) throws SQLException {
		try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
				CallableStatement callableStatement = connection.prepareCall("{ call updateEmail(?, ?) }");) {

			callableStatement.setInt(1, employeeNumber);
			callableStatement.setString(2, newEmail);

			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.execute();

			return callableStatement.getString(2);

		}
	}
	
}
