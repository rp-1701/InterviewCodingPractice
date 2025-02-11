package com.interview.practice.designPattern.factoryPattern;

import com.interview.practice.designPattern.factoryPattern.cakeEnum.CakeTypeEnum;
import com.interview.practice.designPattern.factoryPattern.cakeFactoryIf.CakeFactory;
import com.interview.practice.designPattern.factoryPattern.cakeFactoryIf.CakeFactoryImpl;
import com.interview.practice.designPattern.factoryPattern.cakeIf.Cake;


/**
 * Factory Pattern is one of the Creational Design Pattern.
 * Factory Pattern is used to create objects based on a common interface.
 * It is used when we have a super class with multiple sub-classes and based on input, we need to return one of the sub-class.
 * This pattern takes out the responsibility of instantiation of a class from client
 *
 * TL;DR  Factory Pattern is used to create objects in runtime.
 */
public class User {

    public static void main(String[] args) {
        CakeFactory cakeFactory = new CakeFactoryImpl();
        Cake vanillaCake = cakeFactory.getCake(CakeTypeEnum.VANILLA_CAKE);
        vanillaCake.getCakeDescription();
        Cake blueBerryCake = cakeFactory.getCake(CakeTypeEnum.BLUEBERRY_CAKE);
        blueBerryCake.getCakeDescription();
    }

}
