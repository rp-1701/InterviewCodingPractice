package com.interview.practice.designPattern.strategyPattern.paymentStrategyType;

import com.interview.practice.designPattern.strategyPattern.paymentStrategyIf.PaymentStrategy;

public class NEFT implements PaymentStrategy {

    @Override
    public void pay() {
        System.out.println("Paid using NEFT");
    }
}
