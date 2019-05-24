package com.test.semaphore;

class EvenNumberThread implements Runnable {
	SharedPrinter sp;
	int maxNumberTobePrint;
 
	EvenNumberThread(SharedPrinter sp, int index) {
		this.sp = sp;
		this.maxNumberTobePrint = index;
	}
 
	@Override
	public void run() {
		for (int i = 2; i <= maxNumberTobePrint; i = i + 2) {
			sp.printEvenNumber(i);
		}
 
	}
 
}