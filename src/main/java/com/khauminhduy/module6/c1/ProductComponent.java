package com.khauminhduy.module6.c1;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductComponent {

	private static final String URL = "jdbc:mysql://localhost:3306/classicmodels";
	private static final String USER = "root";
	private static final String PASS = "Aa123456!";

	public boolean storeCLOB(String productLine, InputStreamReader reader) throws SQLException {
		String query = "UPDATE productLines SET htmlDescription = ? WHERE productLine = ?";
		try (Connection connection = DriverManager.getConnection(URL, USER, PASS);) {
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			prepareStatement.setCharacterStream(1, reader);
			prepareStatement.setString(2, productLine);
			int executeUpdate = prepareStatement.executeUpdate();
			return executeUpdate > 0 ? true : false;
		}
	}

	public Reader readCLOB(String productLine) throws SQLException {
		String query = "SELECT htmlDescription FROM productLines WHERE productLine = ?";
		try (Connection connection = DriverManager.getConnection(URL, USER, PASS);) {
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			prepareStatement.setString(1, productLine);
			try (ResultSet resultSet = prepareStatement.executeQuery();) {
				if (resultSet.next()) {
					return resultSet.getCharacterStream("htmlDescription");
				} else {
					return null;
				}
			}

		}
	}

	public boolean storeBLOB(String productLine, FileInputStream fileInputStream) throws SQLException {
		String query = "UPDATE productLines SET image = ? WHERE productLine = ?";
		try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement prepareStatement = connection.prepareStatement(query);) {

			prepareStatement.setBinaryStream(1, fileInputStream);
			prepareStatement.setString(2, productLine);

			int executeUpdate = prepareStatement.executeUpdate();
			return executeUpdate > 0 ? true : false;
		}
	}

	public InputStream readBLOB(String productLine) throws SQLException {
		String query = "SELECT image FROM productLines WHERE productLine = ?";
		try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {

			preparedStatement.setString(1, productLine);
			try (ResultSet resultSet = preparedStatement.executeQuery();) {
				if (resultSet.next()) {
					return resultSet.getBinaryStream("image");
				} else {
					return null;
				}
			}

		}
	}

}
