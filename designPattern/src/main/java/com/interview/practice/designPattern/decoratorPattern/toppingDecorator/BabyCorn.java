package com.interview.practice.designPattern.decoratorPattern.toppingDecorator;

import com.interview.practice.designPattern.decoratorPattern.basePizza.Pizza;

public class BabyCorn implements Decorator {

    Pizza pizza;

    public BabyCorn(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 70;
    }

}
