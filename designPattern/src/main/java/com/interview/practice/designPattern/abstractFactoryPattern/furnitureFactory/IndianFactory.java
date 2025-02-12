package com.interview.practice.designPattern.abstractFactoryPattern.furnitureFactory;

import com.interview.practice.designPattern.abstractFactoryPattern.productIf.Chair;
import com.interview.practice.designPattern.abstractFactoryPattern.productIf.CoffeeTable;
import com.interview.practice.designPattern.abstractFactoryPattern.productIf.Sofa;
import com.interview.practice.designPattern.abstractFactoryPattern.productVariant.Indian.IndianChair;
import com.interview.practice.designPattern.abstractFactoryPattern.productVariant.Indian.IndianCoffeTable;
import com.interview.practice.designPattern.abstractFactoryPattern.productVariant.Indian.IndianSofa;

public class IndianFactory implements FurnitureFactory{

    @Override
    public Chair createChair() {
        return new IndianChair();
    }

    @Override
    public Sofa createSofa() {
        return new IndianSofa();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new IndianCoffeTable();
    }
}
