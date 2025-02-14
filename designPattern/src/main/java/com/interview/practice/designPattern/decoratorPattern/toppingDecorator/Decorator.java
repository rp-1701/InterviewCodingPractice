package com.interview.practice.designPattern.decoratorPattern.toppingDecorator;

import com.interview.practice.designPattern.decoratorPattern.basePizza.Pizza;

public interface Decorator extends Pizza {

    int getCost();

}
