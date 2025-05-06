package com.interview.practice.javacoreandadvance.multiThreading.easy.evenOddVersion1;

public class EvenOddVersion1Client {

    public static void main(String[] args) {

        SharedCounterV1 sharedCounterV1 = new SharedCounterV1(10);

        new Thread(new EvenThread(sharedCounterV1), "EvenThread").start();
        new Thread(new OddThread(sharedCounterV1), "OddThread").start();
    }

}
