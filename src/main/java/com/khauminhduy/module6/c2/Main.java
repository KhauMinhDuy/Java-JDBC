package com.khauminhduy.module6.c2;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		try {
			ProductComponent component = new ProductComponent();
			component.listProductBy("Planes");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
