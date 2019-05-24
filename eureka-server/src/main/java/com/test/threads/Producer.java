package com.test.threads;

import java.util.ArrayList;
import java.util.List;

/* Producer is producing, Producer will allow consumer to
 * consume only when 10 products have been produced (i.e. when production is over).
 */
class Producer implements Runnable{

    List<Integer> sharedQueue;
    int size;
    Integer number;
    Producer(List<Integer> sharedQueue, Integer number, int size){
           this.sharedQueue=sharedQueue;
           this.number = number;
           this.size = size;
    }

    @Override
    public void run(){
            while (true) {
                synchronized (sharedQueue) {
                    while(sharedQueue.size() == size){
                        try {
                            sharedQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(number);
                    sharedQueue.add(number);
                    number++;
                    if( number == 10) {
                        break;
                    }
                    System.out.println("Production is over, consumer can consume.");
                    sharedQueue.notifyAll();    //Production is over, notify consumer thread so that consumer can consume.
                }
            }
    }

}