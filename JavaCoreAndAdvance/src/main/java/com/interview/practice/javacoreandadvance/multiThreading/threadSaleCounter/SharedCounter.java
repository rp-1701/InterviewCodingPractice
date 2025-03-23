package com.interview.practice.javacoreandadvance.multiThreading.threadSaleCounter;

public class SharedCounter {

    private int counter;
    final Object lock = new Object();

    public SharedCounter() {
        this.counter = 0;
    }

    public int getCounter() {
        return counter;
    }

    public void incrementCounter() {
        synchronized (lock) {
            counter++;
        }
    }

    public void decrementCounter() {
        synchronized (lock) {
            counter--;
        }
    }
}
