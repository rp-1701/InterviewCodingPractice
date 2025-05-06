package com.interview.practice.javacoreandadvance.multiThreading.easy.OneToNroundRobin;

import java.util.ArrayList;
import java.util.List;

/*
    print upto M using N Threads using Round Robin pattern
 */
public class OneToNRoundRobin {

    public static void main(String[] args) {

        PrinterConfig printerConfig = new PrinterConfig(10, 4);

        List<Thread> listOfThread = new ArrayList<>();
        for(int i = 0; i < printerConfig.getTotalThread(); i++) {
            listOfThread.add(new Thread(new PatternPrinter(i+1, printerConfig)));
        }

        for(Thread t : listOfThread) {
            t.start();
        }

    }

    public static class PrinterConfig {

        private int totalCount;
        private int totalThread;

        public PrinterConfig(int totalCount, int totalThread) {
            this.totalCount = totalCount;
            this.totalThread = totalThread;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public int getTotalThread() {
            return totalThread;
        }
    }

    public static class PatternPrinter implements Runnable {

        private int threadId;
        private static final Object lock = new Object();
        private static int currentThreadId = 1;
        private static int counter = 1;
        private  PrinterConfig printerConfig;

        public PatternPrinter(int threadId, PrinterConfig printerConfig) {
            this.threadId = threadId;
            this.printerConfig = printerConfig;
        }

        @Override
        public void run() {

            while(true) {
                synchronized (lock) {

                    // waiting condition
                    while(currentThreadId != threadId && counter != printerConfig.getTotalCount() + 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    if(counter >= printerConfig.getTotalCount() + 1) {
                        lock.notifyAll();
                        break;
                    }

                    // happy condition
                    System.out.println(counter + " printed by " + Thread.currentThread().getName());
                    currentThreadId = currentThreadId % printerConfig.getTotalThread() + 1;
                    counter++;
                    lock.notifyAll();
                }

            }

        }
    }

}
