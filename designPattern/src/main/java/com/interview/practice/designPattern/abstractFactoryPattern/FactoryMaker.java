package com.interview.practice.designPattern.abstractFactoryPattern;

import com.interview.practice.designPattern.abstractFactoryPattern.furnitureFactory.FurnitureFactory;
import com.interview.practice.designPattern.abstractFactoryPattern.furnitureFactory.IndianFactory;
import com.interview.practice.designPattern.abstractFactoryPattern.furnitureFactory.IndoWesternFactory;
import com.interview.practice.designPattern.abstractFactoryPattern.furnitureFactory.WesternFactory;

public class FactoryMaker {

    public static FurnitureFactory makeFactory(FactoryTypeEnum factoryType) {

        switch (factoryType) {
            case INDIAN_FACTORY:
                return new IndianFactory();
            case WESTERN_FACTORY:
                return new WesternFactory();
            case INDO_WESTERN_FACTORY:
                return new IndoWesternFactory();
            default:
                throw new IllegalArgumentException("Invalid Factory Type");
        }
    }

}
