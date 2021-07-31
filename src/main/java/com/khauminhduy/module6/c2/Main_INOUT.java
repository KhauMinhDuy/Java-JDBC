package com.khauminhduy.module6.c2;

import java.sql.SQLException;

public class Main_INOUT {

	public static void main(String[] args) {
		try {
			ProductComponent component = new ProductComponent();
			String old_email = component.updateEmail(1002, "dmurphy@classicmodelcars.com");
			
			System.out.println(old_email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
