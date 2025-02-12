package com.interview.practice.designPattern.observerPattern.observer;

public class Anubhav implements Observer{

    @Override
    public void update(String message) {
        System.out.println("Hi Anubhav, "+message);
    }
}
