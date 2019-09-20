package com.luo.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 组合节点--一群会呱呱叫的
 *
 * @author luoxuzheng
 * @create 2019-09-20 8:41
 **/
public class FlockQuackables implements Quackable {

    List<Quackable> list = new ArrayList<>();

    public void add(Quackable quackable) {
        list.add(quackable);
    }

    /**
     * 使用了迭代器模式（自己实现一个迭代器）
     */
    @Override
    public void quack() {
        Iterator<Quackable> iterator = list.iterator();
        for (; iterator.hasNext(); ) {
            Quackable next = iterator.next();
            next.quack();
        }
    }

    @Override
    public boolean registerObserver(Observer observer) {
        Iterator<Quackable> iterator = list.iterator();
        for (; iterator.hasNext(); ) {
            Quackable next = iterator.next();
            next.registerObserver(observer);
        }
        return true;
    }

    @Override
    public boolean notifyObservers() {
        return false;
    }

    @Override
    public boolean removeObserver(Observer observer) {
        Iterator<Quackable> iterator = list.iterator();
        for (; iterator.hasNext(); ) {
            Quackable next = iterator.next();
            next.removeObserver(observer);
        }
        return true;
    }

}
