package com.khauminhduy.module3;


public class c1 {

	public static void main(String[] args) {

		try {
			ConnectComponent comp = new ConnectComponent();
			
			if (comp.tryConnection()) {
				System.out.println("Demo m3c1:");
				System.out.println("The attempt to Connection was a SUCCESS");
			} else {
				System.out.println("Demo m3c1:");
				System.out.println("The attempt to Connection FAILED");
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}
}
