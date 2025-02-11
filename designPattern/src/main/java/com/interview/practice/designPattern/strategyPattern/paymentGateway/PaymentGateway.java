package com.interview.practice.designPattern.strategyPattern.paymentGateway;

import com.interview.practice.designPattern.strategyPattern.paymentStrategyIf.PaymentStrategy;

public class PaymentGateway {

    private PaymentStrategy paymentStrategy;

    public PaymentGateway(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay() {
        paymentStrategy.pay();
    }

    public void changePaymentMethod(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
}
