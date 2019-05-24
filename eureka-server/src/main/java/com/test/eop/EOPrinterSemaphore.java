package com.test.eop;

import java.util.concurrent.Semaphore;

public class EOPrinterSemaphore {
	//boolean evenFlag = false;
   Semaphore evn = new Semaphore(0);
   Semaphore odd = new Semaphore(0);
	/**
	 * Method for printing even numbers
	 * 
	 * @param num
	 */
	public void printEvenNumber(int num) {
		try {
			evn.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(num);
		odd.release();

	}
 
	// Method for printing odd numbers
	public void printOddNumber(int num) {
		try {
			odd.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(num);
		evn.release();
	}
}