package com.interview.practice.designPattern.observerPattern.observable;

import com.interview.practice.designPattern.observerPattern.observer.Observer;
import java.util.ArrayList;
import java.util.List;

public class IphoneObservable implements Observable{

    private List<Observer> observersList;
    private int quantity;

    public IphoneObservable() {
        this.observersList = new ArrayList<>();
        this.quantity = 5;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void addObserver(Observer observer) {
        observersList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observersList.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for(Observer obs : observersList){
            obs.update(message);
        }
    }

    @Override
    public void updateStatus() {
        while(quantity > 0){
            quantity--;
            notifyObservers("Iphone is available, Hurry up!!!");
        }
        notifyObservers("Iphone is out of stock, Sorry!!!");
    }


}
