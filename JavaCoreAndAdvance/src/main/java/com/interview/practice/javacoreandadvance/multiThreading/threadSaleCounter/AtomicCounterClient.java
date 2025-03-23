package com.interview.practice.javacoreandadvance.multiThreading.threadSaleCounter;

public class AtomicCounterClient {

    static SharedAtomicCounter sharedAtomicCounter = new SharedAtomicCounter();

    public static void main(String[] args) throws InterruptedException {

        Thread incrementThread = new Thread(() -> {
            for (int i = 1; i < 1000000; i++) {
                sharedAtomicCounter.incrementCounter();
            }
        });

        Thread decrementThread = new Thread(() -> {
            for (int i = 1; i < 1000000; i++) {
                sharedAtomicCounter.decrementCounter();
            }
        });

        incrementThread.start();
        decrementThread.start();

        incrementThread.join();
        decrementThread.join();

        System.out.println("Final Counter value : " + sharedAtomicCounter.getCounter());


    }

}
