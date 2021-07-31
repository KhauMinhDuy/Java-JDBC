package com.khauminhduy.module7.c2;

public class Main {

	public static void main(String[] args) {
		int customerNumber = 103;
		LineItem item = new LineItem("S10_1678", 20, 50.00);
		try {
			OrderComponent_AC component_AC = new OrderComponent_AC();
			int createOrder = component_AC.createOrder(customerNumber, item);
			System.out.println("New Order Number = " + createOrder);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
