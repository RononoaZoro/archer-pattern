package com.luo.observer;

/**
 * 被观察者
 *
 * @author luoxuzheng
 * @create 2019-09-20 10:35
 **/
public interface Observable {

    boolean registerObserver(Observer observer);
    boolean notifyObservers();
    boolean removeObserver(Observer observer);
}
