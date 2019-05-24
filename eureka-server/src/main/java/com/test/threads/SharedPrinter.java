package com.test.threads;

import java.util.concurrent.Semaphore;

class SharedPrinter {
	boolean isEven;
	private Object oddSemaphore;
	private Object evenSemaphore;
	public SharedPrinter(Object oddSemaphore, Object evenSemaphore, boolean isEven){
		this.oddSemaphore = oddSemaphore;
		this.evenSemaphore = evenSemaphore;
		this.isEven = isEven;
	}

	// creating instance of 2 semaphores , one is for even and another for odd


	//Object evenSemaphore = new Object();
	//Object oddSemaphore = new Object();
 
	/**
	 * Method for printing even numbers
	 * 
	 * @param num
	 */
	public void printEvenNumber(int num) {
		synchronized (evenSemaphore) {
			//while (!isEven) {
				try {
					evenSemaphore.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			//}
		}
		synchronized (oddSemaphore) {
			isEven = true;
			System.out.println(num);
			oddSemaphore.notifyAll();
		}
	}
 
	// Method for printing odd numbers
	public void printOddNum(int num) {
		synchronized (oddSemaphore) {
		//	while (isEven) {
				try {
					oddSemaphore.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		//	}
		}
		synchronized (evenSemaphore) {
			isEven = false;
			System.out.println(num);
			evenSemaphore.notifyAll();
		}
	}
}