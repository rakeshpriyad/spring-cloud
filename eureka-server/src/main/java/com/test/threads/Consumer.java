package com.test.threads;

import java.util.List;

class Consumer extends Thread{
    Producer prod;
    List<Integer> sharedQueue;
    Integer number;
    int maxSize;
    Consumer(List<Integer> sharedQueue, Integer number, int maxSize){

        this.sharedQueue=sharedQueue;
        this.number = number;
        this.maxSize = maxSize;

    }
    
    public void run(){
           /*
            * consumer will wait till producer is producing.
            */
           while (true) {
               synchronized (sharedQueue) {
                   while (sharedQueue.isEmpty()) {
                       System.out.println("Consumer waiting for production to get over.");
                       try {
                           this.sharedQueue.wait();
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }

                   }
                  int n = sharedQueue.remove(0);
                   if (n==10) {
                       break;
                   }
                   //System.out.println(sharedQueue.get(0));
                   sharedQueue.notify();
               }
           }
           

           
    }
    
}