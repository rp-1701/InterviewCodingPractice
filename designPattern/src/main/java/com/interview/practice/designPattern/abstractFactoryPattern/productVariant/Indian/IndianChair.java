package com.interview.practice.designPattern.abstractFactoryPattern.productVariant.Indian;

import com.interview.practice.designPattern.abstractFactoryPattern.productIf.Chair;

public class IndianChair implements Chair {

    @Override
    public void getChairDescription() {
        System.out.println("This is Indian Chair");
    }
}
