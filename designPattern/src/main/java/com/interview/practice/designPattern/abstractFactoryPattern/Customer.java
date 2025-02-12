package com.interview.practice.designPattern.abstractFactoryPattern;

import com.interview.practice.designPattern.abstractFactoryPattern.furnitureFactory.FurnitureFactory;

/**
 * Abstract Factory Pattern is used when families of related products is designed to be used together and it is
 * required to ensure that the products from the same family are used together. The pattern is used to create
 * a set of related objects, or dependent objects without specifying their concrete classes.
 */
public class Customer {

    public static void main(String[] args) {

        FurnitureFactory furnitureFactory = FactoryMaker.makeFactory(FactoryTypeEnum.INDIAN_FACTORY);
        furnitureFactory.createChair().getChairDescription();
        furnitureFactory.createSofa().getSofaDescription();
        furnitureFactory.createCoffeeTable().getCoffeeTableDescription();

        furnitureFactory = FactoryMaker.makeFactory(FactoryTypeEnum.WESTERN_FACTORY);
        furnitureFactory.createChair().getChairDescription();
        furnitureFactory.createSofa().getSofaDescription();
        furnitureFactory.createCoffeeTable().getCoffeeTableDescription();

        furnitureFactory = FactoryMaker.makeFactory(FactoryTypeEnum.INDO_WESTERN_FACTORY);
        furnitureFactory.createChair().getChairDescription();
        furnitureFactory.createSofa().getSofaDescription();
        furnitureFactory.createCoffeeTable().getCoffeeTableDescription();
    }

}
