package com.luo.singleton.test;

import com.luo.singleton.lazy.LazyOne;

import java.util.concurrent.CountDownLatch;

/**
 * 测试类
 *
 * @author luoxuzheng
 * @create 2019-08-10 16:03
 **/
public class ThreadSafeTest {

    public static void main(String[] args) {

        int count = 200;
        //发令枪
        CountDownLatch countDownLatch = new CountDownLatch(count);
        long start = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                try {


                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                LazyOne instance = LazyOne.getInstance();
                System.out.println(System.currentTimeMillis() + ":" + instance);
            }).start();
            countDownLatch.countDown();
        }

        //主线程与其他线程是异步的，这个耗时只能看出来线程创建所需的时间
        long end = System.currentTimeMillis();

        System.out.println("总耗时：" + (end - start));


    }
}
