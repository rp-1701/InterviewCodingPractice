package com.interview.practice.springbootCoreAndAdvance.springAOP;

import com.interview.practice.springbootCoreAndAdvance.springAOP.paymentService.PaymentServiceIf;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PaymentServiceClient {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(PaymentServiceClient.class, args);
        PaymentServiceIf paymentService = context.getBean(PaymentServiceIf.class);
        paymentService.makePayment(100);

    }

}
