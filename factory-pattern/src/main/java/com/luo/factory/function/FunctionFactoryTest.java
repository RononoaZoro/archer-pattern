package com.luo.factory.function;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * 工厂方法模式测试
 *
 * @author luoxuzheng
 * @create 2019-08-10 11:44
 **/
public class FunctionFactoryTest {

    public static void main(String[] args) {
        Factory mengNiuFactory = new MengNiuFactory();
        Factory yiLiFactory = new YiLiFactory();
        Factory teLunSuFactory = new TeLunSuFactory();

        System.out.println(mengNiuFactory.getMilk());
        System.out.println(yiLiFactory.getMilk());
        System.out.println(teLunSuFactory.getMilk());
    }
}
