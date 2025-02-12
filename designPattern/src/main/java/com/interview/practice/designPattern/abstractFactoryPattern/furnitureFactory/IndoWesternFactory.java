package com.interview.practice.designPattern.abstractFactoryPattern.furnitureFactory;

import com.interview.practice.designPattern.abstractFactoryPattern.productIf.Chair;
import com.interview.practice.designPattern.abstractFactoryPattern.productIf.CoffeeTable;
import com.interview.practice.designPattern.abstractFactoryPattern.productIf.Sofa;
import com.interview.practice.designPattern.abstractFactoryPattern.productVariant.IndoWestern.IndoWesternChair;
import com.interview.practice.designPattern.abstractFactoryPattern.productVariant.IndoWestern.IndoWesternCoffeTable;
import com.interview.practice.designPattern.abstractFactoryPattern.productVariant.IndoWestern.IndoWesternSofa;

public class IndoWesternFactory implements FurnitureFactory{

    @Override
    public Chair createChair() {
        return new IndoWesternChair();
    }

    @Override
    public Sofa createSofa() {
        return new IndoWesternSofa();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new IndoWesternCoffeTable();
    }
}
