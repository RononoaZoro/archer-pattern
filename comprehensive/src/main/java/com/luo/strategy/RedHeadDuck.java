package com.luo.strategy;

import com.luo.strategy.abst.Duck;

/**
 * @author luoxuzheng
 * @create 2019-09-13 16:29
 **/
public class RedHeadDuck extends Duck {
    @Override
    protected void display() {
        System.out.println("我是红头鸭");
    }

}
