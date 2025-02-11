package com.interview.practice.designPattern.factoryPattern.cakeFactoryIf;

import com.interview.practice.designPattern.factoryPattern.cakeEnum.CakeTypeEnum;
import com.interview.practice.designPattern.factoryPattern.cakeIf.BlueBerryCake;
import com.interview.practice.designPattern.factoryPattern.cakeIf.Cake;
import com.interview.practice.designPattern.factoryPattern.cakeIf.ChocolateCake;
import com.interview.practice.designPattern.factoryPattern.cakeIf.VanillaCake;

public class CakeFactoryImpl implements CakeFactory{

    @Override
    public Cake getCake(CakeTypeEnum cakeType) {

        switch (cakeType){
            case VANILLA_CAKE:
                return new VanillaCake();
            case CHOCOLATE_CAKE:
                return new ChocolateCake();
            case BLUEBERRY_CAKE:
                return new BlueBerryCake();
            default:
                throw new IllegalArgumentException("Invalid Cake Type");
        }
    }
}
