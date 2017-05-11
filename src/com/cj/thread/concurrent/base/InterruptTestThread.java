package com.cj.thread.concurrent.base;

public class InterruptTestThread extends Thread{
	
	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			System.out.println("������...");
			long time = System.currentTimeMillis();
			while(System.currentTimeMillis() - time < 1000) {
				
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("��ʼ...");
		
		Thread t = new InterruptTestThread();
		t.start();
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t.interrupt();
		
		System.out.println("����...");
	}
	
}
