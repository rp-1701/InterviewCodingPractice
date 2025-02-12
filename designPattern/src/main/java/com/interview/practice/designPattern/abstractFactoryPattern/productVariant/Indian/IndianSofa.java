package com.interview.practice.designPattern.abstractFactoryPattern.productVariant.Indian;

import com.interview.practice.designPattern.abstractFactoryPattern.productIf.Sofa;

public class IndianSofa implements Sofa {

    @Override
    public void getSofaDescription() {
        System.out.println("This is Indian Sofa");
    }

}
