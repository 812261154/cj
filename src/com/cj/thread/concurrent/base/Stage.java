package com.cj.thread.concurrent.base;

/**
 * @author yuchaoc
 *
 */
public class Stage extends Thread {
	
	public void run() {
		
		System.out.println("��ӭ�տ���������..");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e2) {
			e2.printStackTrace();
		}
		
		ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
		ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();
		
		Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty, "�峯���");
		Thread armyOfRevolt = new Thread(armyTaskOfRevolt, "ũ�������");
		
		armyOfSuiDynasty.start();
		armyOfRevolt.start();
		
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("˫����ս��������·ɱ������ҧ��...");
		
		Thread chenyaojin = new KeyPersonThread();
		chenyaojin.setName("��ҧ��");
		
		System.out.println("��ҧ���������ǽ���ս����ʹũ�񰲾���ҵ...");
		
		armyTaskOfSuiDynasty.keepRunning = false;
		armyTaskOfRevolt.keepRunning = false;
//		armyOfRevolt.stop();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		chenyaojin.start();
		
		try {
			chenyaojin.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("��������������..");
	}
	
	public static void main(String[] args) {
		new Stage().start();
	}
	
}
