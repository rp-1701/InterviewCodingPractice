package com.interview.practice.javacoreandadvance.multiThreading.patternPrinting;

public class PatternPrint {

    static boolean threadATurn = true;
    static final Object lock = new Object();
    static int totalNumber = 20;

    public static void main(String[] args) {

        Thread threadA = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (!threadATurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    if (totalNumber == 0) {
                        break;
                    }
                    System.out.print("A");
                    threadATurn = false;
                    totalNumber--;
                    lock.notify();


                }
            }


        });

        Thread threadB = new Thread(() -> {
            while (totalNumber > 0) {
                synchronized (lock) {
                    while (threadATurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    if (totalNumber == 0) {
                        break;
                    }

                    System.out.print("B");
                    threadATurn = true;
                    totalNumber--;
                    lock.notify();


                }
            }
        });

        threadA.start();
        threadB.start();
    }

}
