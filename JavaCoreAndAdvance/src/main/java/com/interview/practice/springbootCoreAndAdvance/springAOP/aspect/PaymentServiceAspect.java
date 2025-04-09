package com.interview.practice.springbootCoreAndAdvance.springAOP.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PaymentServiceAspect {

    @Before("execution(* com.interview.practice.springbootCoreAndAdvance.springAOP.paymentService.PaymentServiceIf.makePayment(..))")
    public void beforePayment() {
        System.out.println("Processing of Payment Started");
    }

    @After("execution(* com.interview.practice.springbootCoreAndAdvance.springAOP.paymentService.PaymentServiceIf.makePayment(..))")
    public void afterPayment() {
        System.out.println("Processing of Payment Completed");
    }
}
