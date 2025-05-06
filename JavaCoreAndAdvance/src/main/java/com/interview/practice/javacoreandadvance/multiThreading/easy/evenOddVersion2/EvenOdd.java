package com.interview.practice.javacoreandadvance.multiThreading.easy.evenOddVersion2;

public class EvenOdd {

    static boolean evenThreadTurn = false;
    static final Object lock = new Object();

    public static void main(String[] args) {

        Thread evenThread = new Thread(() -> {

            try {
                for (int i = 2; i <= 20; i = i + 2) {
                    synchronized (lock) {
                        while (!evenThreadTurn) {
                            lock.wait();
                        }
                        System.out.print(i + " ");
                        evenThreadTurn = false;
                        lock.notify();
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Error occurred in evenThread : " + e.getMessage());
            }

        });

        Thread oddThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 20; i = i + 2) {
                    synchronized (lock) {
                        while (evenThreadTurn) {
                            lock.wait();
                        }
                        System.out.print(i + " ");
                        evenThreadTurn = true;
                        lock.notify();
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Error occurred in oddThread : " + e.getMessage());
            }
        });

        oddThread.start();
        evenThread.start();

    }

}
