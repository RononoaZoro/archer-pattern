package com.luo.factory.abstr;

/**
 * @author luoxuzheng
 * @create 2019-08-10 12:00
 **/
public class AbstrFactoryTest {

    public static void main(String[] args) {
        MilkFactory milkFactory = new MilkFactory();

        System.out.println(milkFactory.getMengNiu());
    }
}
