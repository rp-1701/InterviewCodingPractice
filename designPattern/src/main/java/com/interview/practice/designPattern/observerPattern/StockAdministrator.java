package com.interview.practice.designPattern.observerPattern;

import com.interview.practice.designPattern.observerPattern.observable.IphoneObservable;
import com.interview.practice.designPattern.observerPattern.observer.Anubhav;
import com.interview.practice.designPattern.observerPattern.observer.Observer;
import com.interview.practice.designPattern.observerPattern.observer.Ravi;

public class StockAdministrator {

    public static void main(String[] args) {

        IphoneObservable iphone = new IphoneObservable();
        Observer observer1 = new Ravi();
        Observer observer2 = new Anubhav();
        iphone.addObserver(observer1);
        iphone.addObserver(observer2);
        iphone.updateStatus();
        iphone.removeObserver(observer2);
        iphone.setQuantity(5);
        iphone.updateStatus();
    }

}
