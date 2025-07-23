package com.interview.practice.lowleveldesign.rateLimiting_algorithm.leaky_bucket.usingCounter;

public class LeakyBucket {

    private long bucketCapacity;
    private long currentBucketSize;
    private long leakRate; // tokens per second
    private long lastLeakTime;

    public LeakyBucket(long bucketCapacity, long leakRate) {
        this.bucketCapacity = bucketCapacity;
        this.leakRate = leakRate;
        this.currentBucketSize = 0;
        this.lastLeakTime = System.currentTimeMillis();
    }

    public long getBucketCapacity() {
        return bucketCapacity;
    }

    public long getCurrentBucketSize() {
        return currentBucketSize;
    }

    public long getLeakRate() {
        return leakRate;
    }

    public long getLastLeakTime() {
        return lastLeakTime;
    }

    public boolean addRequest() {
        leak();

        if (currentBucketSize < bucketCapacity) {
            currentBucketSize++;
            return true;
        }

        return false;
    }

    private void leak() {
        long currentTime = System.currentTimeMillis();
        long timeElapsed = currentTime - lastLeakTime;
        
        // Convert time to seconds and calculate tokens to leak
        long tokensToLeak = (timeElapsed * leakRate) / 1000;
        
        if (tokensToLeak > 0) {
            currentBucketSize = Math.max(0, currentBucketSize - tokensToLeak);
            lastLeakTime = currentTime;
        }
    }
} 