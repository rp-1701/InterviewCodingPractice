package com.interview.practice.javacoreandadvance.multiThreading.patternPrinting;

public class LetterNumber {

    private static final Object lock = new Object();
    private static boolean letterThreadTurn = true;

    public static void main(String[] args) {

        Thread letterThread = new Thread(() -> {
            try {
                for (char c = 'A'; c <= 'Z'; c++) {
                    synchronized (lock) {
                        while(!letterThreadTurn) {
                            lock.wait();
                        }
                        System.out.print(c + " ");
                        letterThreadTurn = false;
                        lock.notify();
                    }

                }
            } catch (InterruptedException e) {
                System.out.println("Error occurred in letterThread : " + e.getMessage());
            }
        });

        Thread numberThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 26; i++) {
                    synchronized (lock) {
                        while(letterThreadTurn) {
                            lock.wait();
                        }
                        System.out.print(i + " ");
                        letterThreadTurn = true;
                        lock.notify();
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Error occurred in numberThread : " + e.getMessage());
            }
        });

        letterThread.start();
        numberThread.start();
    }

}
