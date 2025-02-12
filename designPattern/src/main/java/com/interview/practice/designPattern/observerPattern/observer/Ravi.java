package com.interview.practice.designPattern.observerPattern.observer;

public class Ravi implements Observer{

    @Override
    public void update(String message) {
        System.out.println("Hi Ravi, "+message);
    }
}
