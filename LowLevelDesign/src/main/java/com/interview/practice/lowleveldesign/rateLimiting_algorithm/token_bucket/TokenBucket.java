package com.interview.practice.lowleveldesign.rateLimiting_algorithm.token_bucket;

public class TokenBucket {

    private long totalCapacity;
    private long currentNumOfTokens;
    private long lastRefillTime;
    private long refillInterval;
    private long tokenPerInterval;

    public TokenBucket(long totalCapacity, long refillInterval, long tokenPerInterval) {
        this.totalCapacity = totalCapacity;
        this.currentNumOfTokens = totalCapacity;
        this.refillInterval = refillInterval;
        this.tokenPerInterval = tokenPerInterval;
        this.lastRefillTime = System.currentTimeMillis();
    }

    public long getTotalCapacity() {
        return totalCapacity;
    }

    public long getCurrentNumOfTokens() {
        return currentNumOfTokens;
    }

    public long getLastRefillTime() {
        return lastRefillTime;
    }

    public long getRefillInterval() {
        return refillInterval;
    }

    public long getTokenPerInterval() {
        return tokenPerInterval;
    }

    public boolean consume() {

        refill();

        if(currentNumOfTokens > 0) {
            --currentNumOfTokens;
            return true;
        }

        return false;
    }

    private void refill() {

        long currentTime = System.currentTimeMillis();
        long duration = currentTime - lastRefillTime;

        if(duration >= refillInterval) {
            long completedInterval = duration / refillInterval;
            long tokenToBeAdded = completedInterval * tokenPerInterval;
            // refill the bucket
            currentNumOfTokens = Math.min(totalCapacity, currentNumOfTokens + tokenToBeAdded);
            // update the last refill time
            lastRefillTime += completedInterval * refillInterval;
        }

    }


}
