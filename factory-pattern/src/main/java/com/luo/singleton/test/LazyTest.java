package com.luo.singleton.test;

import com.luo.singleton.lazy.LazyOne;
import com.luo.singleton.lazy.LazyTwo;

/**
 * @author luoxuzheng
 * @create 2019-08-10 16:17
 **/
public class LazyTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 200000000;i ++) {
            Object obj = LazyTwo.getInstance();
        }
        long end = System.currentTimeMillis();
        System.out.println("总耗时：" + (end - start));
    }
}
