package com.interview.practice.lowleveldesign.rateLimiting_algorithm.token_bucket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TokenBucketClient {

    public static void main(String[] args) throws InterruptedException {

        TokenBucket tokenBucket = new TokenBucket(5, 3000, 5);
        int numberOfRequests = 50;
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= numberOfRequests; i++) {
            int currentRequest = i;
            executor.execute(() -> {
                boolean allowed = tokenBucket.consume();
                if (allowed) {
                    System.out.println("Request " + currentRequest + " forwarded " + Thread.currentThread().getName() + " avaliable token " + tokenBucket.getCurrentNumOfTokens());
                } else {
                    System.out.println("Request " + currentRequest + " rejected " + Thread.currentThread().getName()+ " avaliable token " + tokenBucket.getCurrentNumOfTokens());
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
