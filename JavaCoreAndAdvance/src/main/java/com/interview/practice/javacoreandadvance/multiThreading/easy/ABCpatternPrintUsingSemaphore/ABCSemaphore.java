package com.interview.practice.javacoreandadvance.multiThreading.easy.ABCpatternPrintUsingSemaphore;

import java.util.concurrent.Semaphore;

public class ABCSemaphore {

    private Semaphore semaphoreA = new Semaphore(1);
    private Semaphore semaphoreB = new Semaphore(0);
    private Semaphore semaphoreC = new Semaphore(0);

    public void printABC(int n) {
        new Thread(() -> {
            for(int i = 0; i < n; i++) {
                try{
                    semaphoreA.acquire();
                    System.out.print("A");
                    semaphoreB.release();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();

        new Thread(() -> {
            for(int i = 0; i < n; i++) {
                try{
                    semaphoreB.acquire();
                    System.out.print("B");
                    semaphoreC.release();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();

        new Thread(() -> {
            for(int i = 0; i < n; i++) {
                try{
                    semaphoreC.acquire();
                    System.out.print("C");
                    semaphoreA.release();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();



    }

}
