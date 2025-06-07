package com.interview.practice.javacoreandadvance.multiThreading.easy.ABCpatternPrintUsingSemaphore;

public class ABCSemaphoreClient {
    public static void main(String[] args) {

        ABCSemaphore abcSemaphore = new ABCSemaphore();
        abcSemaphore.printABC(5);
    }

}
