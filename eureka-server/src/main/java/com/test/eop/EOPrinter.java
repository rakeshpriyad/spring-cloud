package com.test.eop;

import java.util.concurrent.Semaphore;

class EOPrinter {
	boolean evenFlag = false;
 
	/**
	 * Method for printing even numbers
	 * 
	 * @param num
	 */
	//public void printEvenNumber(int num, boolean evenFlag) {
		public void printEvenNumber(int num) {
		synchronized (this) {
			while (!evenFlag) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(num);
			evenFlag =false;
			notify();
		}
	}
 
	// Method for printing odd numbers
	//public void printOddNum(int num,boolean evenFlag) {
	public void printOddNumber(int num) {
		synchronized (this) {
			while (evenFlag) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(num);
			evenFlag =true;
			notify();
		}
	}
}