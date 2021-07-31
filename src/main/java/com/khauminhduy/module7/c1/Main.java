package com.khauminhduy.module7.c1;

public class Main implements Runnable{

	public static void main(String[] args) {
		new ConnectionPool();
		System.out.println("Thread   Conn");
		System.out.println("------   ----");
		
		for(int i = 0; i < 5; i++) {
			Thread thread = new Thread(new Main(), "Main_" + i);
			thread.start();
		}
	}

	@Override
	public void run() {
		for(int i = 0; i < 3; i++) {
			try {
				OrderComponent component = new OrderComponent();
				component.tryConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
