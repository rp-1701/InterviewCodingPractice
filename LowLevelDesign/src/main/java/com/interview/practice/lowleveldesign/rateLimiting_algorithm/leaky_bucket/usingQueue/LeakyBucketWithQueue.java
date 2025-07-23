package com.interview.practice.lowleveldesign.rateLimiting_algorithm.leaky_bucket.usingQueue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LeakyBucketWithQueue {

    private Queue<Request> bucket;
    private long bucketCapacity;
    private long leakRate; // requests per second
    private ScheduledExecutorService scheduler;
    private volatile boolean isRunning;

    public LeakyBucketWithQueue(long bucketCapacity, long leakRate) {
        this.bucket = new ConcurrentLinkedQueue<>();
        this.bucketCapacity = bucketCapacity;
        this.leakRate = leakRate;
        this.scheduler = Executors.newScheduledThreadPool(1);
        this.isRunning = true;
        
        // Start the leak process
        startLeaking();
    }

    public boolean addRequest(String requestId) {
        if (bucket.size() < bucketCapacity) {
            bucket.offer(new Request(requestId, System.currentTimeMillis()));
            return true;
        }
        return false;
    }

    private void startLeaking() {
        long leakInterval = 1000 / leakRate; // Convert to milliseconds
        
        scheduler.scheduleAtFixedRate(() -> {
            if (!isRunning) {
                return;
            }
            
            Request request = bucket.poll();
            if (request != null) {
                long processingTime = System.currentTimeMillis() - request.getArrivalTime();
                System.out.println("Processing request: " + request.getRequestId() + 
                                 " (waited: " + processingTime + "ms)");
            }
        }, 0, leakInterval, TimeUnit.MILLISECONDS);
    }

    public long getCurrentBucketSize() {
        return bucket.size();
    }

    public long getBucketCapacity() {
        return bucketCapacity;
    }

    public long getLeakRate() {
        return leakRate;
    }

    public void shutdown() {
        isRunning = false;
        scheduler.shutdown();
    }

    private static class Request {
        private String requestId;
        private long arrivalTime;

        public Request(String requestId, long arrivalTime) {
            this.requestId = requestId;
            this.arrivalTime = arrivalTime;
        }

        public String getRequestId() {
            return requestId;
        }

        public long getArrivalTime() {
            return arrivalTime;
        }
    }
} 