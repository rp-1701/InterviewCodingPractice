package com.interview.practice.javacoreandadvance.multiThreading.threadSaleCounter;

import java.util.concurrent.atomic.AtomicInteger;

public class SharedAtomicCounter {

    private AtomicInteger counter;

    public SharedAtomicCounter() {
        this.counter = new AtomicInteger(0);
    }

    public AtomicInteger getCounter() {
        return counter;
    }

    public void incrementCounter() {
        counter.incrementAndGet();
    }

    public void decrementCounter() {
        counter.decrementAndGet();
    }
}
