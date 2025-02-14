package com.interview.practice.designPattern.decoratorPattern.toppingDecorator;

import com.interview.practice.designPattern.decoratorPattern.basePizza.Pizza;

public class Cheese implements Decorator {

    Pizza pizza;

    public Cheese(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 50;
    }

}
