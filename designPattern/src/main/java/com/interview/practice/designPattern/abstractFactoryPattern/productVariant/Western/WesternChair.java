package com.interview.practice.designPattern.abstractFactoryPattern.productVariant.Western;

import com.interview.practice.designPattern.abstractFactoryPattern.productIf.Chair;

public class WesternChair implements Chair {

    @Override
    public void getChairDescription() {
        System.out.println("This is Western Chair");
    }
}
