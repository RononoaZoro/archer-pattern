package com.luo.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 被观察者实现类
 *
 * @author luoxuzheng
 * @create 2019-09-20 10:37
 **/
public class QuackObservable implements Observable {

    private Observable duck;

    private List<Observer> observers = new ArrayList<>();

    public QuackObservable(Observable duck) {
        this.duck = duck;
    }

    @Override
    public boolean registerObserver(Observer observer) {
        observers.add(observer);
        return true;
    }

    @Override
    public boolean notifyObservers() {
        Iterator<Observer> iterator = observers.iterator();
        while (iterator.hasNext()){
            Observer next = iterator.next();
            next.update(duck);
        }
        return false;
    }

    @Override
    public boolean removeObserver(Observer observer) {
        observers.remove(observer);
        return true;
    }
}
