package com.luo.factory.simple;

import com.luo.factory.Milk;

/**
 * 简单工厂模式测试
 *
 * @author luoxuzheng
 * @create 2019-08-10 11:11
 **/
public class SimpleFactoryTest {

    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        Milk yili = simpleFactory.getMilk("yili");
        Milk sanlu = simpleFactory.getMilk("sanlu");
        Milk emptyStr = simpleFactory.getMilk("");
        Milk nullPo = simpleFactory.getMilk(null);

        System.out.println(yili);
        System.out.println(sanlu);
        System.out.println(emptyStr);
        System.out.println(nullPo);
    }
}
