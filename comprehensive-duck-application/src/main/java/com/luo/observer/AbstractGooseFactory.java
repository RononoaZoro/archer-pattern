package com.luo.observer;

/**
 * 鹅的抽象工厂
 *
 * @author luoxuzheng
 * @create 2019-09-20 8:20
 **/
public abstract class AbstractGooseFactory {

    abstract GooseAdapter createGooseAdapter();

}
