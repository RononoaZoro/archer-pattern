package com.luo.observer;

/**
 * 鸭鸣器
 *
 * @author luoxuzheng
 * @create 2019-09-20 7:50
 **/
public class DuckCall implements Quackable {

    private QuackObservable quackObservable;

    public DuckCall() {
        this.quackObservable = new QuackObservable(this);
    }


    public void quack() {
        System.out.println("DuckCall kwak");
        notifyObservers();
    }

    @Override
    public boolean registerObserver(Observer observer) {
        quackObservable.registerObserver(observer);
        return true;
    }

    @Override
    public boolean notifyObservers() {
        quackObservable.notifyObservers();
        return true;
    }

    @Override
    public boolean removeObserver(Observer observer) {
        quackObservable.removeObserver(observer);
        return true;
    }
}
