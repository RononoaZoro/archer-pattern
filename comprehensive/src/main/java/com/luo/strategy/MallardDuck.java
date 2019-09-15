package com.luo.strategy;

import com.luo.strategy.abst.Duck;

/**
 * 模型鸭
 *
 * @author luoxuzheng
 * @create 2019-09-13 16:25
 **/
public class MallardDuck extends Duck {


    @Override
    protected void display() {
        System.out.println("我是模型鸭");
    }



}
