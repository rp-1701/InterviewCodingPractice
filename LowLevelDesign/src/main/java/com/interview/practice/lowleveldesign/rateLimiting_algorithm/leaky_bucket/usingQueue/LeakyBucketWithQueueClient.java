package com.interview.practice.lowleveldesign.rateLimiting_algorithm.leaky_bucket.usingQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LeakyBucketWithQueueClient {

    public static void main(String[] args) throws InterruptedException {

        // Bucket capacity: 10, Leak rate: 2 requests per second
        LeakyBucketWithQueue leakyBucket = new LeakyBucketWithQueue(10, 2);
        int numberOfRequests = 50;
        ExecutorService executor = Executors.newFixedThreadPool(10);

        System.out.println("=== Queue-based Leaky Bucket Test ===");
        System.out.println("Bucket Capacity: " + leakyBucket.getBucketCapacity());
        System.out.println("Leak Rate: " + leakyBucket.getLeakRate() + " requests/second");
        System.out.println("Total Requests: " + numberOfRequests);
        System.out.println("=====================================");

        for (int i = 1; i <= numberOfRequests; i++) {
            int currentRequest = i;
            executor.execute(() -> {
                boolean allowed = leakyBucket.addRequest("REQ-" + currentRequest);
                if (allowed) {
                    System.out.println("Request " + currentRequest + " accepted " + 
                                     Thread.currentThread().getName() + " bucket size " + 
                                     leakyBucket.getCurrentBucketSize());
                } else {
                    System.out.println("Request " + currentRequest + " rejected " + 
                                     Thread.currentThread().getName() + " bucket size " + 
                                     leakyBucket.getCurrentBucketSize());
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
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        // Wait for all requests to be processed
        Thread.sleep(5000);
        leakyBucket.shutdown();
        
        System.out.println("Final bucket size: " + leakyBucket.getCurrentBucketSize());
    }
} 