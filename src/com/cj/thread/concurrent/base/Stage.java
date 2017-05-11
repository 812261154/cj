package com.cj.thread.concurrent.base;

/**
 * @author yuchaoc
 *
 */
public class Stage extends Thread {
	
	public void run() {
		
		System.out.println("欢迎收看隋唐演义..");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e2) {
			e2.printStackTrace();
		}
		
		ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
		ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();
		
		Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty, "隋朝大军");
		Thread armyOfRevolt = new Thread(armyTaskOfRevolt, "农民起义军");
		
		armyOfSuiDynasty.start();
		armyOfRevolt.start();
		
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("双方激战正酣，半路杀出个程咬金...");
		
		Thread chenyaojin = new KeyPersonThread();
		chenyaojin.setName("程咬金");
		
		System.out.println("程咬金的理想就是结束战争，使农民安居乐业...");
		
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
		
		System.out.println("隋唐演义演完了..");
	}
	
	public static void main(String[] args) {
		new Stage().start();
	}
	
}
