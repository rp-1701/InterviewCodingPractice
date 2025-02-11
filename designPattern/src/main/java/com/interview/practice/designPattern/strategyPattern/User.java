package com.interview.practice.designPattern.strategyPattern;

import com.interview.practice.designPattern.strategyPattern.paymentGateway.PaymentGateway;
import com.interview.practice.designPattern.strategyPattern.paymentStrategyType.CreditCard;
import com.interview.practice.designPattern.strategyPattern.paymentStrategyType.UPI;

/**
 * Strategy pattern is used when we have multiple algorithm for a
 * specific task and client decides the actual implementation to be used at runtime.
 */
public class User {

    public static void main(String[] args) {
        PaymentGateway paymentGateway = new PaymentGateway(new UPI());
        paymentGateway.pay();
        paymentGateway.changePaymentMethod(new CreditCard());
        paymentGateway.pay();
    }

}
