package com.test.eop;

public class OddNumberThread implements Runnable {
	private EOPrinter eop;
	private int max;


	public OddNumberThread(EOPrinter eop, int max) {
		this.eop = eop;
		this.max = max;
	}
 
	@Override
	public void run() {
		for (int i = 1; i <= max; i = i + 2) {
			eop.printOddNumber(i);
		}
 
	}
 
}