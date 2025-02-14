package com.interview.practice.designPattern.decoratorPattern.toppingDecorator;

import com.interview.practice.designPattern.decoratorPattern.basePizza.Pizza;

public class ExtraVegies implements Decorator {

    Pizza pizza;

    public ExtraVegies(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 80;
    }

}
