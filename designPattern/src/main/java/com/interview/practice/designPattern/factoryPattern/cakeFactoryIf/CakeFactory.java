package com.interview.practice.designPattern.factoryPattern.cakeFactoryIf;

import com.interview.practice.designPattern.factoryPattern.cakeEnum.CakeTypeEnum;
import com.interview.practice.designPattern.factoryPattern.cakeIf.Cake;

public interface CakeFactory {

    Cake getCake(CakeTypeEnum cakeType);

}
