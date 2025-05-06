package com.interview.practice.javacoreandadvance.multiThreading.easy.evenOddVersion3;

public class PrinterThread implements Runnable {

    private SharedCounterV3 sharedCounterV3;
    private int threadId;

    public PrinterThread(SharedCounterV3 sharedCounterV3, int threadId) {
        this.sharedCounterV3 = sharedCounterV3;
        this.threadId = threadId;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (sharedCounterV3) {
                // check if not even --> then wait
                while (sharedCounterV3.getCurrentCount() % 2 != threadId && sharedCounterV3.getCurrentCount() <= sharedCounterV3.getTotalCount()) {
                    try {
                        sharedCounterV3.wait(); // handle the spurious wake up
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                if (sharedCounterV3.getCurrentCount() > sharedCounterV3.getTotalCount()) {
                    sharedCounterV3.notify();
                    break;
                }

                sharedCounterV3.print();
                sharedCounterV3.notify();

            }
        }
    }
}
