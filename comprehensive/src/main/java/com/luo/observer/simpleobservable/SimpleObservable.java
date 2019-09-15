package com.luo.observer.simpleobservable;

import java.util.Observable;
import java.util.Observer;

/**
 * @author luoxuzheng
 * @create 2019-09-15 20:02
 **/
public class SimpleObservable extends Observable {
    private Integer value;

    public void setValue(Integer value){
        this.value = value;
        setChanged();
        notifyObservers(value);
    }

    public Integer getValue() {
        return value;
    }
}
