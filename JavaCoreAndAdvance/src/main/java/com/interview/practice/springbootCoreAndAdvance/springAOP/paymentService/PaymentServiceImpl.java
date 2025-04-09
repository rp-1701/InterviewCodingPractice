package com.interview.practice.springbootCoreAndAdvance.springAOP.paymentService;

import org.springframework.stereotype.Component;

@Component
public class PaymentServiceImpl implements PaymentServiceIf{

    @Override
    public void makePayment(int amount) {
        System.out.println("Making Payment of "+amount);
    }
}
