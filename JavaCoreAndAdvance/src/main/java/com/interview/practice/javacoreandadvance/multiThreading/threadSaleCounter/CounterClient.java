package com.interview.practice.javacoreandadvance.multiThreading.threadSaleCounter;

public class CounterClient {

    static SharedCounter sharedCounter = new SharedCounter();

    public static void main(String[] args) throws InterruptedException {

        Thread incrementThread = new Thread(() -> {
            for (int i = 1; i <= 1000000; i++) {
                sharedCounter.incrementCounter();
            }
        });

        Thread decrementThread = new Thread(() -> {
            for (int i = 1; i <= 1000000; i++) {
                sharedCounter.decrementCounter();
            }
        });

        incrementThread.start();
        decrementThread.start();

        incrementThread.join();
        decrementThread.join();

        System.out.println("Final Counter Value : " + sharedCounter.getCounter());


    }

}
