package com.khauminhduy.module6.c1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class Main_Write_CLOB {

	public static void main(String[] args) {
		try {
			ProductComponent component = new ProductComponent();
			String productLine = "Planes";
			String pathFile = "src/main/resources/";
			String fileName = "JanesAllWorldAircraft1913_704482.txt";
			File file = new File(pathFile + fileName);
			FileReader fileReader = new FileReader(file);
			boolean storeCLOB = component.storeCLOB(productLine, fileReader);
			fileReader.close();
			if(storeCLOB) {
				System.out.println("Success");
			} else {
				System.out.println("Fail");
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

	}
}
