package com.interview.practice.javacoreandadvance.multiThreading.patternPrinting;

public class ABCPatternPrint {

    public static void main(String[] args) {

        Thread threadA = new Thread(new PrinterThread(1, 'A', 3));
        Thread threadB = new Thread(new PrinterThread(2, 'B', 3));
        Thread threadC = new Thread(new PrinterThread(3, 'C', 3));

        threadA.start();
        threadB.start();
        threadC.start();

    }

    public static class PrinterThread implements Runnable {

        int threadId;
        char threadCharacter;
        int totalThread;
        static int currentThreadId = 1;
        static final Object lock = new Object();
        static int totalCount = 12;

        public PrinterThread(int threadId, char threadCharacter, int totalThread) {
            this.threadId = threadId;
            this.threadCharacter = threadCharacter;
            this.totalThread = totalThread;
        }

        @Override
        public void run() {

            while(true) {
                synchronized (lock) {
                    while(currentThreadId != threadId && totalCount != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    if(totalCount == 0) {
                        lock.notifyAll();
                        break;
                    }
                    System.out.print(threadCharacter);
                    totalCount--;
                    // calculate the next threadId
                    currentThreadId = currentThreadId % totalThread + 1;
                    lock.notifyAll();
                }
            }

        }
    }

}
