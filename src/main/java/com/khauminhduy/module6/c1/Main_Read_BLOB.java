package com.khauminhduy.module6.c1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

public class Main_Read_BLOB {

	public static void main(String[] args) {
		try {
			ProductComponent component = new ProductComponent();
			String productLine = "Planes";
			String pathFile = "src/main/resources/";
			String fileName = "bi-plane-read.png";
			InputStream readBLOB = component.readBLOB(productLine);
			if(readBLOB == null) {
				System.out.println("Could not read image data from database");
				return;
			}
			File file = new File(pathFile + fileName);
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			System.out.println("Writing image to file: " + fileName);
			byte[] buff = new byte[2046];
			while(readBLOB.read(buff) > 0) {
				fileOutputStream.write(buff);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

	}

}
