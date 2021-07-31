package com.khauminhduy.module6.c1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;

public class Main_Write_BLOB {

	public static void main(String[] args) {
		try {
			ProductComponent component = new ProductComponent();
			String productLine = "Planes";
			String pathFile = "src/main/resources/";
			String fileName = "bi-plane.png";
			File file = new File(pathFile + fileName);
			FileInputStream fileInputStream = new FileInputStream(file);
			boolean storeCLOB = component.storeBLOB(productLine, fileInputStream);
			fileInputStream.close();
			if (storeCLOB) {
				System.out.println("Success");
			} else {
				System.out.println("Fail");
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

}
