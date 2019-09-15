package com.luo.observer.simpleobservable;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者
 *
 * @author luoxuzheng
 * @create 2019-09-15 20:01
 **/
public class SimpleObserver implements Observer {
    private Integer value;
    private Observable observable;

    public SimpleObserver(Observable observable) {
        this.observable = observable;
        this.observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {

        //1、被通知
        this.value = (Integer) arg;
        display();

        //2、主动拉取
        if(o instanceof SimpleObservable){
            this.value = ((SimpleObservable) o).getValue();
            display();
        }
    }

    public void display() {
        System.out.println("value:" + value);
    }

}
