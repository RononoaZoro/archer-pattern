package com.luo.steady;

/**
 * @author luoxuzheng
 * @create 2019-08-12 12:37
 **/
public class StaticProxyTest {
    public static void main(String[] args) {

        //只能帮儿子找对象
        //不能帮表妹、不能帮陌生人
        Person son = new Son();
        Father father = new Father(son);

        father.findLove();
    }
}
