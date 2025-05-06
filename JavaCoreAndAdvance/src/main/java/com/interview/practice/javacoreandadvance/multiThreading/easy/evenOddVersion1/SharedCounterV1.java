package com.interview.practice.javacoreandadvance.multiThreading.easy.evenOddVersion1;

public class SharedCounterV1 {

    private int totalCount;
    private int currentCount = 1;

    public SharedCounterV1(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    public void print() {
        System.out.println(currentCount + " printed by " + Thread.currentThread().getName());
        increment();
    }

    private void increment() {
        currentCount++;
    }
}
