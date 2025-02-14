package com.interview.practice.designPattern.decoratorPattern.toppingDecorator;

import com.interview.practice.designPattern.decoratorPattern.basePizza.Pizza;

public class Jalepeno implements Decorator{

    Pizza pizza;

    public Jalepeno(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 60;
    }

}
