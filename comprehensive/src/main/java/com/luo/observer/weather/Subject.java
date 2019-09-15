package com.luo.observer.weather;

/**
 * @author luoxuzheng
 * @create 2019-09-15 20:18
 **/
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
