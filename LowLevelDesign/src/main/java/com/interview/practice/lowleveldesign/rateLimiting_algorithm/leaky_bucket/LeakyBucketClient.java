package com.interview.practice.lowleveldesign.rateLimiting_algorithm.leaky_bucket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LeakyBucketClient {

    public static void main(String[] args) throws InterruptedException {

        // Bucket capacity: 10, Leak rate: 2 tokens per second
        LeakyBucket leakyBucket = new LeakyBucket(10, 2);
        int numberOfRequests = 50;
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= numberOfRequests; i++) {
            int currentRequest = i;
            executor.execute(() -> {
                boolean allowed = leakyBucket.addRequest();
                if (allowed) {
                    System.out.println("Request " + currentRequest + " accepted " + Thread.currentThread().getName() + " bucket size " + leakyBucket.getCurrentBucketSize());
                } else {
                    System.out.println("Request " + currentRequest + " rejected " + Thread.currentThread().getName() + " bucket size " + leakyBucket.getCurrentBucketSize());
                }
            });

            // Simulate delay between requests
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
} 