package com.luo.strategy.impl.quack;

import com.luo.strategy.inter.QuackBehavior;

/**
 * @author luoxuzheng
 * @create 2019-09-13 16:32
 **/
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("我只会呱呱叫");
    }
}
