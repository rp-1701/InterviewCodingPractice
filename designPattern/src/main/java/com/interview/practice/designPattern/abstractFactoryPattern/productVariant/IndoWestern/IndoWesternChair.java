package com.interview.practice.designPattern.abstractFactoryPattern.productVariant.IndoWestern;

import com.interview.practice.designPattern.abstractFactoryPattern.productIf.Chair;

public class IndoWesternChair implements Chair {

    @Override
    public void getChairDescription() {
        System.out.println("This is Indo Western Chair");
    }

}
