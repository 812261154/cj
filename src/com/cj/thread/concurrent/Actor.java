package com.cj.thread.concurrent;

public class Actor extends Thread {
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		System.out.println(getName() + "��һ����Ա��");
		
		int count = 0;
		boolean keepRunning = true;
		
		while(keepRunning) {
			System.out.println(getName() + "��̨����:" + (++count));
			
			if(count == 100) {
				keepRunning = false;
			}
			
			if(count % 10 == 0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		System.out.println(getName() + "���ݽ�����");
	}
	
	public static void main(String[] args) {
		Thread actor = new Actor();
		actor.setName("Mr. Thread");
		actor.start();
		
		Thread actress = new Thread(new Actress(), "Ms. Runnable");
		actress.start();
	}
	
}


class Actress implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "��һ����Ա��");
		
		int count = 0;
		boolean keepRunning = true;
		
		while(keepRunning) {
			System.out.println(Thread.currentThread().getName() + "��̨����:" + (++count));
			
			if(count == 100) {
				keepRunning = false;
			}
			
			if(count % 10 == 0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		System.out.println(Thread.currentThread().getName() + "���ݽ�����");
		
	}
	
}
