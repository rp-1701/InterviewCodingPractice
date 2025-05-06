package com.interview.practice.javacoreandadvance.multiThreading.easy.evenOddUsingSemaphore;

public class EvenOddSemaphoreClient {

    public static void main(String[] args) {

        EvenOddSemaphore evenOddSemaphore = new EvenOddSemaphore(10);
        evenOddSemaphore.printEvenOdd();
    }

}
