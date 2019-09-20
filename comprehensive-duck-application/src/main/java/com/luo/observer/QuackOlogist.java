package com.luo.observer;

/**
 * 呱呱叫学家
 *
 * @author luoxuzheng
 * @create 2019-09-20 11:08
 **/
public class QuackOlogist implements Observer {
    @Override
    public void update(Observable duck) {
        System.out.println("QuackOlogist: "+ duck.getClass().getSimpleName() + " just quacked.");
    }
}
