package com.cj.thread.concurrent.base;

public class ArmyRunnable implements Runnable {
	
	volatile boolean keepRunning = true;

	@Override
	public void run() {
			System.out.println(Thread.currentThread().getName() + "��ʼս��...");
			while(keepRunning) {
				for(int i = 0; i < 5; i++) {
					System.out.println(Thread.currentThread().getName() + "�����Է�[" + i + "]");
					Thread.yield();
				}
			}
			System.out.println(Thread.currentThread().getName() + "����ս��...");
	}

}
