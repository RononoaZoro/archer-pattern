package com.luo.observer;

/**
 * 橡皮鸭
 *
 * @author luoxuzheng
 * @create 2019-09-20 7:50
 **/
public class RubberDuck implements Quackable {

    private QuackObservable quackObservable;

    public RubberDuck() {
        this.quackObservable = new QuackObservable(this);
    }

    public void quack() {
        System.out.println("RubberDuck squeak");
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
