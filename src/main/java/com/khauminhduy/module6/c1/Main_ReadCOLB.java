package com.khauminhduy.module6.c1;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

public class Main_ReadCOLB {

	public static void main(String[] args) {
		try {
			ProductComponent component = new ProductComponent();
			String productLine = "Planes";
			Reader readCLOB = component.readCLOB(productLine);
			int chr = 0;
			while((chr = readCLOB.read()) != -1) {
				System.out.write(chr);
			}
			
			readCLOB.close();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

}
