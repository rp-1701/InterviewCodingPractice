package com.interview.practice.designPattern.abstractFactoryPattern.furnitureFactory;

import com.interview.practice.designPattern.abstractFactoryPattern.productIf.Chair;
import com.interview.practice.designPattern.abstractFactoryPattern.productIf.CoffeeTable;
import com.interview.practice.designPattern.abstractFactoryPattern.productIf.Sofa;

public interface FurnitureFactory {

    Chair createChair();

    Sofa createSofa();

    CoffeeTable createCoffeeTable();

}
