package com.test.threads;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerWithWaitNotify {
    public static void main(String args[]) throws InterruptedException{
           List<Integer> sharedQueue = new ArrayList<>();
           Integer number = 1;
           Producer prod=new Producer(sharedQueue,1, 1);
           Consumer cons=new Consumer(sharedQueue,1, 1);
           
           Thread prodThread=new Thread(prod,"prodThread");
           Thread consThread=new Thread(cons,"consThread");
           
           consThread.start();     //start consumer thread.
           Thread.sleep(100);      //This minor delay will ensure that consumer thread starts before producer thread.
           prodThread.start();     //start producer thread.
           
           
    }
 
}