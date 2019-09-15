package com.luo.observer.weather;

/**
 * @author luoxuzheng
 * @create 2019-09-15 20:19
 **/
public interface Observer {

    void update(float temp, float humidity, float pressure);
}
