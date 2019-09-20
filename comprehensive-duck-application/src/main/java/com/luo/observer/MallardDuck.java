package com.luo.observer;

/**
 * 绿头鸭
 *
 * @author luoxuzheng
 * @create 2019-09-20 7:50
 **/
public class MallardDuck implements Quackable {

    private QuackObservable quackObservable;

    public MallardDuck() {
        this.quackObservable = new QuackObservable(this);
    }

    @Override
    public void quack() {
        System.out.println("MallardDuck quack");
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
