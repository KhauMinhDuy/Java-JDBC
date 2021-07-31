package com.khauminhduy.module7.c1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderComponent {

	public void tryConnection() {
		try(Connection connection = ConnectionPool.getConnection();
				PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM orderDetails");) {
			
			prepareStatement.execute();
			
			String msg = Thread.currentThread().getName() + " --> " + this.getConnectionId(connection);
			System.out.println(msg);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private String getConnectionId(Connection con) throws SQLException {
		String conId = con.toString();
		int lastPos = conId.length() - 2;
		conId = conId.substring(lastPos);
		return conId;
	}

}
