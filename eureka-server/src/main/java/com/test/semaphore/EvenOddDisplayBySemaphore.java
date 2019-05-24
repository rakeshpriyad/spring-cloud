package com.test.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenOddDisplayBySemaphore {
 
	public static void main(String[] args) {
		SharedPrinter printer = new SharedPrinter();
 
		System.out.println("two different threads to print odd and even number upto max provided, starting from  1 : ");
		// Starting two threads
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new EvenNumberThread(printer, 10));
		executor.execute(new OddNumberThread(printer, 10));
		executor.shutdown();
	}
 
}