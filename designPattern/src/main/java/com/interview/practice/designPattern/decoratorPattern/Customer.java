package com.interview.practice.designPattern.decoratorPattern;

import com.interview.practice.designPattern.decoratorPattern.basePizza.ChickenBiryaniPizza;
import com.interview.practice.designPattern.decoratorPattern.basePizza.Pizza;
import com.interview.practice.designPattern.decoratorPattern.basePizza.VegDelight;
import com.interview.practice.designPattern.decoratorPattern.toppingDecorator.BabyCorn;
import com.interview.practice.designPattern.decoratorPattern.toppingDecorator.Cheese;
import com.interview.practice.designPattern.decoratorPattern.toppingDecorator.ExtraVegies;
import com.interview.practice.designPattern.decoratorPattern.toppingDecorator.Jalepeno;

/**
 * Decorator Pattern allows dynamic addition of responsibilities to objects without modifying their existing code
 */
public class Customer {

    public static void main(String[] args) {

        Pizza vegDelight = new VegDelight();
        System.out.println("Cost of VegDelight: " + vegDelight.getCost());

        // Adding BabyCorn to VegDelight
        Pizza vegDelight_babyCorn = new BabyCorn(vegDelight);
        System.out.println("Cost of VegDelight with BabyCorn: " + vegDelight_babyCorn.getCost());

        Pizza chikenBiryani_chesse_extraVeggies_jalepeno = new Jalepeno(new ExtraVegies(new Cheese(new ChickenBiryaniPizza())));
        System.out.println("Cost of ChickenBiryaniPizza with Cheese, ExtraVegies and Jalepeno: " + chikenBiryani_chesse_extraVeggies_jalepeno.getCost());


    }

}
