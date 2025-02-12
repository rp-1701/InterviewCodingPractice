package com.interview.practice.designPattern.abstractFactoryPattern.productVariant.IndoWestern;

import com.interview.practice.designPattern.abstractFactoryPattern.productIf.CoffeeTable;

public class IndoWesternCoffeTable implements CoffeeTable {

    @Override
    public void getCoffeeTableDescription() {
        System.out.println("This is Indo Western Coffee Table");
    }

}
