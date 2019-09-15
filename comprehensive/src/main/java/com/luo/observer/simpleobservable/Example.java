package com.luo.observer.simpleobservable;


import java.util.Observer;

/**
 * @author luoxuzheng
 * @create 2019-09-15 19:39
 **/
public class Example {

    public static void main(String[] args) {
        SimpleObservable observable = new SimpleObservable();
        Observer observer = new SimpleObserver(observable);
        observable.setValue(1);
    }
}
