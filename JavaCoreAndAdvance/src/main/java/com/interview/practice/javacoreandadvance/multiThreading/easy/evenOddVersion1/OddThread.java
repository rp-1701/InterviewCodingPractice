package com.interview.practice.javacoreandadvance.multiThreading.easy.evenOddVersion1;

public class OddThread implements Runnable {

    private final SharedCounterV1 sharedCounterV1;

    public OddThread(SharedCounterV1 sharedCounterV1) {
        this.sharedCounterV1 = sharedCounterV1;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (sharedCounterV1) {
                // check if not odd --> then wait
                while (sharedCounterV1.getCurrentCount() % 2 == 0 && sharedCounterV1.getCurrentCount() <= sharedCounterV1.getTotalCount()) {
                    try {
                        sharedCounterV1.wait(); // handle the spurious wake up
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (sharedCounterV1.getCurrentCount() > sharedCounterV1.getTotalCount()) {
                    sharedCounterV1.notify();
                    break;
                }

                sharedCounterV1.print();
                sharedCounterV1.notify();

            }
        }
    }
}
