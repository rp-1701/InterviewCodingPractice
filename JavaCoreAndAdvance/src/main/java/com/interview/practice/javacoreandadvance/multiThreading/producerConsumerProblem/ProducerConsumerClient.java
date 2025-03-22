package com.interview.practice.javacoreandadvance.multiThreading.producerConsumerProblem;

public class ProducerConsumerClient {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource(5);

        Thread itemProducer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    sharedResource.produce(i);
                }
            } catch (InterruptedException e) {
                System.out.println("Error Occurred while Producing item : " + e.getMessage());
            }
        });

        Thread itemConsumer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    sharedResource.consume();
                }
            } catch (InterruptedException e) {
                System.out.println("Error Occurred while Consuming item : " + e.getMessage());
            }
        });

        itemProducer.start();
        itemConsumer.start();
    }
}
