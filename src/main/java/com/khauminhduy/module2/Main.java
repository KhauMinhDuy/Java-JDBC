package com.khauminhduy.module2;

public class Main {

	public static void main(String[] args) {
		try {
			ConnectComponent comp = new ConnectComponent();

			if (comp.getConnection()) {
				System.out.println("Demo m2c1:");
				System.out.println("The attempt to Connection was a SUCCESS");
			} else {
				System.out.println("Demo m2c1:");
				System.out.println("The attempt to Connection FAILED");
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

}
