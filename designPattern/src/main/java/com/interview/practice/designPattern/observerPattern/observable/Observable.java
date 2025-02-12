package com.interview.practice.designPattern.observerPattern.observable;

import com.interview.practice.designPattern.observerPattern.observer.Observer;

public interface Observable {

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(String message);

    void updateStatus();

}
