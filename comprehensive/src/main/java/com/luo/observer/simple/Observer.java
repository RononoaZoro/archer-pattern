package com.luo.observer.simple;

/**
 * 观察者
 *
 * @author luoxuzheng
 * @create 2019-09-15 19:43
 **/
public interface Observer {

    /**
     * 通知
     * @param value
     */
    void update(Integer value);
}
