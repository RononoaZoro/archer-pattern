package com.luo.observer;

/**
 * 鹅
 *
 * @author luoxuzheng
 * @create 2019-09-20 8:02
 **/
public class GooseAdapter implements Quackable {
    private Goose goose;

    private QuackObservable quackObservable;


    public GooseAdapter(Goose goose) {
        this.goose = goose;
        this.quackObservable = new QuackObservable(this);
    }

    public void quack() {
        goose.honk();
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
