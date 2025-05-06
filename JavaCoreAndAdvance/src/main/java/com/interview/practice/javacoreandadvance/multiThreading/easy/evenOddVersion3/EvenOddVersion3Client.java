package com.interview.practice.javacoreandadvance.multiThreading.easy.evenOddVersion3;

public class EvenOddVersion3Client {

    public static void main(String[] args) {

        SharedCounterV3 sharedCounterV3 = new SharedCounterV3(10);
        new Thread(new PrinterThread(sharedCounterV3, 0), "EvenThread").start();
        new Thread(new PrinterThread(sharedCounterV3, 1), "OddThread").start();
    }

}
