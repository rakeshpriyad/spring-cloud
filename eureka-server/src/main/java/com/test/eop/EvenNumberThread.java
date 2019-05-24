package com.test.eop;

public class EvenNumberThread implements Runnable {
	private EOPrinter eop;
	private int max;


	public EvenNumberThread(EOPrinter eop, int max) {
		this.eop = eop;
		this.max = max;
	}
 
	@Override
	public void run() {
		for (int i = 2; i <= max; i = i + 2) {
			eop.printEvenNumber(i);
		}
 
	}
 
}