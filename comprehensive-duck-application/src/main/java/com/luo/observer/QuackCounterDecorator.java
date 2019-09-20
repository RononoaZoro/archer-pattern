package com.luo.observer;

/**
 * 鸭鸣计数器
 *
 * @author luoxuzheng
 * @create 2019-09-20 8:09
 **/
public class QuackCounterDecorator implements Quackable {

    private Quackable quackable;
    private static Integer numberOfQuacks = 0;

    public QuackCounterDecorator(Quackable quackable) {
        this.quackable = quackable;
    }

    public void quack() {
        quackable.quack();
        numberOfQuacks++;
    }

    public static Integer getNumberOfQuacks() {
        return numberOfQuacks;
    }

    @Override
    public boolean registerObserver(Observer observer) {
        quackable.registerObserver(observer);
        return true;
    }

    @Override
    public boolean notifyObservers() {
        quackable.notifyObservers();
        return true;
    }

    @Override
    public boolean removeObserver(Observer observer) {
        quackable.removeObserver(observer);
        return true;
    }
}
