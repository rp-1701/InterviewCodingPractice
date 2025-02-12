package com.interview.practice.designPattern.abstractFactoryPattern.furnitureFactory;

import com.interview.practice.designPattern.abstractFactoryPattern.productIf.Chair;
import com.interview.practice.designPattern.abstractFactoryPattern.productIf.CoffeeTable;
import com.interview.practice.designPattern.abstractFactoryPattern.productIf.Sofa;
import com.interview.practice.designPattern.abstractFactoryPattern.productVariant.Western.WesternChair;
import com.interview.practice.designPattern.abstractFactoryPattern.productVariant.Western.WesternCoffeeTable;
import com.interview.practice.designPattern.abstractFactoryPattern.productVariant.Western.WesternSofa;

public class WesternFactory implements FurnitureFactory {

    @Override
    public Chair createChair() {
        return new WesternChair();
    }

    @Override
    public Sofa createSofa() {
        return new WesternSofa();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new WesternCoffeeTable();
    }

}
