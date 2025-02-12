package com.interview.practice.designPattern.abstractFactoryPattern.productVariant.Western;

import com.interview.practice.designPattern.abstractFactoryPattern.productIf.CoffeeTable;

public class WesternCoffeeTable implements CoffeeTable {

    @Override
    public void getCoffeeTableDescription() {
        System.out.println("This is Western Coffee Table");
    }
}
