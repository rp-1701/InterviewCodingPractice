package com.interview.practice.designPattern.strategyPattern.paymentStrategyType;

import com.interview.practice.designPattern.strategyPattern.paymentStrategyIf.PaymentStrategy;

public class CreditCard implements PaymentStrategy {

    @Override
    public void pay() {
        System.out.println("Paid using Credit Card");
    }
}
