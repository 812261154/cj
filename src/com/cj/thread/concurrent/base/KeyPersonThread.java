package com.cj.thread.concurrent.base;

public class KeyPersonThread extends Thread {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "��ʼ��ս����");
		
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "��ͻ�ҹ����������������");
		}
		
		System.out.println(Thread.currentThread().getName() + "������ս����");
	}
	
}
