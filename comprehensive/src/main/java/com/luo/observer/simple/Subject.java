package com.luo.observer.simple;

/**
 * 被观察者
 *
 * @author luoxuzheng
 * @create 2019-09-15 19:42
 **/
public interface Subject {

    /**
     * 注册观察者
     * @param observer
     */
    void registerObserver(Observer observer);

    /**
     * 移除观察者
     * @param observer
     */
    void removeObserver(Observer observer);

    /**
     * 通知观察者
     */
    void notifyObservers();

}
