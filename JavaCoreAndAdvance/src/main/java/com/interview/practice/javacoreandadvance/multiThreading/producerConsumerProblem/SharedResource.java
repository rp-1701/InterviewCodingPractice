package com.interview.practice.javacoreandadvance.multiThreading.producerConsumerProblem;

import java.util.ArrayDeque;
import java.util.Queue;

public class SharedResource {

    public Queue<Integer> queue;
    private int max_capacity;

    public SharedResource(int size) {
        this.max_capacity = size;
        this.queue = new ArrayDeque<>(max_capacity);
    }

    public synchronized void produce(int item) throws InterruptedException {

        // check if the queue is full
        while(queue.size() >= max_capacity) {
            System.out.println("Queue is full " + Thread.currentThread().getName() + " is waiting to produce");
            // need to wait until consumer thread consumes the item from the queue.
            wait();
        }
        queue.add(item);
        System.out.println(Thread.currentThread().getName() + " produced item " + item);
        // need to notify consumer thread to start consuming
        notify();
    }

    public synchronized void consume() throws InterruptedException {

        // check if queue is empty
        while(queue.isEmpty()) {
            System.out.println("Queue is Empty " + Thread.currentThread().getName() + " is waiting to consume");
            // need to wait until producer thread produce an item
            wait();
        }

        Integer consumeItem = queue.poll();
        System.out.println(Thread.currentThread().getName() + " consumed item " + consumeItem);
        // need to notify producer thread to start producing
        notify();
    }

}
