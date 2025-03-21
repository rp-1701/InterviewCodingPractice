package com.interview.practice.javacoreandadvance.multiThreading;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Factorial {

    public static void main(String[] args) throws InterruptedException {

        List<Long> list = Arrays.asList(10L, 20L, 30L, 40L, 50L, 60L, 70L, 80L, 90L, 100L);

        List<MultiplierThread> multiplierThreads = new ArrayList<>();
        List<AdditionThread> additionThreads = new ArrayList<>();

        List<Long> squareOfNum = MultiplierThread.squareOfNum;

        for(Long num : list) {
            multiplierThreads.add(new MultiplierThread(num));
        }

        for(MultiplierThread thread : multiplierThreads) {
            thread.start();
        }

        for(MultiplierThread thread : multiplierThreads) {
            System.out.println("currently running Thread :: " + thread.getName());
            thread.join();
            System.out.println("Operation Done for Thread :: " + thread.getName());
        }

        System.out.println("elements in square of Num");
        squareOfNum.forEach(System.out::println);
        System.out.println("-----------------");
        System.out.println("Addition Thread Started");

        for(Long num : squareOfNum) {
            additionThreads.add(new AdditionThread(num));
        }

        for(AdditionThread thread : additionThreads) {
            thread.start();
        }

        AdditionThread.finalListOfNum.forEach(System.out::println);
        System.out.println("Addition Thread Ended");



//        List<Long> inputNumbers = Arrays.asList(2324L, 4656L, 23L, 5556L);
//
//        List<FactorialThread> threadList = new ArrayList<>();
//
//        for(long num : inputNumbers) {
//            threadList.add(new FactorialThread(num));
//        }
//
//        for(FactorialThread thread : threadList) {
//            thread.start();
//        }
//
//        for(FactorialThread thread : threadList) {
//            System.out.println("currently running Thread :: " + thread.getName());
//            thread.join();
//            System.out.println("Operation Done for Thread :: " + thread.getName());
//        }
//
//        for (int i = 0; i < inputNumbers.size(); i++) {
//            FactorialThread factorialThread = threadList.get(i);
//            if (factorialThread.isFinished()) {
//                System.out.println("Factorial of " + inputNumbers.get(i) + " is " + factorialThread.getResult());
//            } else {
//                System.out.println("The calculation for " + inputNumbers.get(i) + " is still in progress");
//            }
//        }
    }
    
    private static class FactorialThread extends Thread {
        
        private long factorialNum;
        private boolean isFinished;
        private BigInteger result = BigInteger.ZERO;
        
        public FactorialThread(long number) {
            this.factorialNum = number;
        }

        public long getFactorialNum() {
            return factorialNum;
        }

        public boolean isFinished() {
            return isFinished;
        }

        public BigInteger getResult() {
            return result;
        }

        @Override
        public void run() {
            result = calculateFactorial(factorialNum);
            isFinished = true;
        }

        private BigInteger calculateFactorial(long factorialNum) {
            BigInteger tempResult = BigInteger.ONE;

            for(long i = factorialNum; i > 0; i--) {
                tempResult = tempResult.multiply(new BigInteger(String.valueOf(i)));
            }
            return tempResult;
        }
    }

    private static class MultiplierThread extends Thread {

        private long numToMultiply;
        private long result;
        private static List<Long> squareOfNum = new ArrayList<>();


        public MultiplierThread(long num) {
            this.numToMultiply = num;
        }

        public long getResult() {
            return result;
        }



        @Override
        public void run() {

            result = numToMultiply * numToMultiply * numToMultiply * numToMultiply ;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            squareOfNum.add(result);

        }
    }

    private static class AdditionThread extends Thread {

        private long numToAdd;
        private long result;
        private static List<Long> finalListOfNum = new ArrayList<>();


        public AdditionThread(long num) {
            this.numToAdd = num;
        }

        public long getResult() {
            return result;
        }

        @Override
        public void run() {

            result = numToAdd + 1;
            finalListOfNum.add(result);
        }
    }
    

}
