package com.luo.dynamic.cglib;

/**
 * @author luoxuzheng
 * @create 2019-08-12 14:59
 **/
public class CglibProxyTest {

    public static void main(String[] args) {
        AZheng obj = (AZheng) new CglibMeiPo().getInstance(AZheng.class);

        obj.findLove();


        System.out.println("--------------------------------");
        System.out.println(obj.getClass());

    }
}
