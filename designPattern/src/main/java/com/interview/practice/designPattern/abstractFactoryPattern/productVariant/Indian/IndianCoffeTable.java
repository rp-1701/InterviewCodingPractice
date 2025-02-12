package com.interview.practice.designPattern.abstractFactoryPattern.productVariant.Indian;

import com.interview.practice.designPattern.abstractFactoryPattern.productIf.CoffeeTable;

public class IndianCoffeTable implements CoffeeTable {

    @Override
    public void getCoffeeTableDescription() {
        System.out.println("This is Indian Coffee Table");
    }
}
