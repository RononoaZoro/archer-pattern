package com.luo.observer.impl;

import com.luo.observer.inter.Subject;

/**
 * @author luoxuzheng
 * @create 2019-09-13 21:05
 **/
public class WeatherData implements Subject {
    @Override
    public void registerObserver() {

    }

    @Override
    public void removeObserver() {

    }

    @Override
    public void notifyObserver() {

    }

    String getTemperature(){
        return "温度";
    }

    String getHumidity(){
        return "湿度";
    }

    String getPressure(){
        return "压力";
    }

    void messurementChanged(){
        System.out.println("数据发生了改变");
    }
}
