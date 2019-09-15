package com.luo.observer.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luoxuzheng
 * @create 2019-09-15 19:47
 **/
public class SimpleSubject implements Subject {

    private List<Observer> observers;
    private Integer value = 0;

    public SimpleSubject() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = this.observers.indexOf(observer);
        if (index >= 0)
            this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : this.observers) {
            observer.update(value);
        }
    }

    public void setValue(Integer value) {
        this.value = value;
        notifyObservers();
    }
}
