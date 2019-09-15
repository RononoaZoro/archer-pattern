package com.luo.observer.inter;

/**
 * 主题
 *
 * @author luoxuzheng
 * @create 2019-09-13 21:03
 **/
public interface Subject {

    void registerObserver();

    void removeObserver();

    void notifyObserver();
}
