package com.luo.strategy.impl.fly;

import com.luo.strategy.inter.FlyBehavior;

/**
 * @author luoxuzheng
 * @create 2019-09-13 16:31
 **/
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("我不会飞");
    }
}
