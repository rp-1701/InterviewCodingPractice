package com.interview.practice.designPattern.abstractFactoryPattern.productVariant.IndoWestern;

import com.interview.practice.designPattern.abstractFactoryPattern.productIf.Sofa;

public class IndoWesternSofa implements Sofa {

    @Override
    public void getSofaDescription() {
        System.out.println("This is Indo Western Sofa");
    }

}
