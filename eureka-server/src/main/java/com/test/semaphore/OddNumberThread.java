package com.test.semaphore;

class OddNumberThread implements Runnable {
	SharedPrinter printer;
	int maxNumberTobePrint;
 
	OddNumberThread(SharedPrinter sp, int index) {
		this.printer = sp;
		this.maxNumberTobePrint = index;
	}
 
	@Override
	public void run() {
		for (int i = 1; i <= maxNumberTobePrint; i = i + 2) {
			printer.printOddNum(i);
		}
	}
}