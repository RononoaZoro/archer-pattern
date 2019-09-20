package com.luo.observer;

/**
 * 鸭子的抽象工厂
 *
 * @author luoxuzheng
 * @create 2019-09-20 8:17
 **/
public abstract class AbstractDuckFactory {

    abstract Quackable createDuckCall();
    abstract Quackable createMallardDuck();
    abstract Quackable createRedHeadDuck();
    abstract Quackable createRubberDuck();
//    abstract Quackable createGooseAdapter();
}
