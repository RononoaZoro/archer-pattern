package com.luo.singleton.test;

import com.luo.singleton.lazy.LazyThree;

import java.lang.reflect.Constructor;

/**
 * @author luoxuzheng
 * @create 2019-08-10 16:11
 **/
public class LazyThreeTest {

    public static void main(String[] args) {

        try{
            Class<?> clazz = LazyThree.class;

            Constructor<?> c = clazz.getDeclaredConstructor(null);

            c.setAccessible(true);

            Object o1 = c.newInstance();

            Object o2 = c.newInstance();
            System.out.println(o1 == o2);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
