package com.interview.practice.designPattern.abstractFactoryPattern.productVariant.Western;

import com.interview.practice.designPattern.abstractFactoryPattern.productIf.Sofa;

public class WesternSofa implements Sofa {

    @Override
    public void getSofaDescription() {
        System.out.println("This is Western Sofa");
    }
}
