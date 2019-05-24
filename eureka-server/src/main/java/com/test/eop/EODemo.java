package com.test.eop;

import java.util.stream.IntStream;

public class EODemo {
    public static void main(String[] args) {
        EOPrinter eop = new EOPrinter();
        int max =10;

        getOddThread(max, eop).start();
        getEvenThread(max, eop).start();

    }

    public static Thread getOddThread(int max,EOPrinter eop){
       /* Runnable odd = () -> {
           *//* for(int i =1; i<=max; i=i+2){
                eop.printOddNum(i);
            }*//*
            IntStream.rangeClosed(1, max).filter(i -> i%2 != 0 ).forEach(i -> eop.printOddNumber(i));
        };*/
        //Thread t1 = new Thread(odd);
        return new Thread(() -> IntStream.rangeClosed(1, max).filter(i -> i%2 != 0 ).forEach(i -> eop.printOddNumber(i)));
    }
    public static Thread getEvenThread(int max,EOPrinter eop){
        /* Runnable even = () -> {
         *//* for(int i =2; i<=max; i=i+2){
                eop.printEvenNumber(i);
            }*//*
            IntStream.rangeClosed(1, max).filter(i -> i%2 == 0 ).forEach(i -> eop.printEvenNumber(i));
        };*/
        //Thread t1 = new Thread(odd);
        return new Thread(() -> IntStream.rangeClosed(1, max).filter(i -> i%2 == 0 ).forEach(i -> eop.printEvenNumber(i)));
    }
}
