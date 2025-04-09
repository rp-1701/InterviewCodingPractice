package com.interview.practice.springbootCoreAndAdvance.springAOP.paymentService;

import org.springframework.stereotype.Component;

@Component
public interface PaymentServiceIf {

    void makePayment(int amount);

}
