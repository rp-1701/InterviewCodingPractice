package com.interview.practice.javacoreandadvance.multiThreading.easy.evenOddUsingSemaphore;

import java.util.concurrent.Semaphore;

public class EvenOddSemaphore {

    private int total_count;
    private final Semaphore evenSemaphore = new Semaphore(0);
    private final Semaphore oddSemaphore = new Semaphore(1);

    public EvenOddSemaphore(int total_count) {
        this.total_count = total_count;
    }

    public void printEvenOdd() {
        new Thread(() -> {
            for(int i = 2; i <= total_count; i += 2) {
                try {
                    evenSemaphore.acquire(); // when acquire is called internally it reduce the permit count by 1
                    System.out.print(i + " ");
                    oddSemaphore.release(); // when release is called internally it increase the permit count by 1
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

        }).start();

        new Thread(() -> {
            for(int i = 1; i <= total_count; i += 2) {
                try {
                    oddSemaphore.acquire();
                    System.out.print(i + " ");
                    evenSemaphore.release();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

        }).start();
    }
}
