package com.luo.dynamic.gpproxy;

import com.luo.steady.Person;

/**
 * @author luoxuzheng
 * @create 2019-09-20 10:49
 **/
public class Girl implements Person {
    public void findLove(){
        System.out.println("高富帅");
        System.out.println("身高180cm");
        System.out.println("胸大，6块腹肌");

    }

    @Override
    public void zufangzi() {
        System.out.println("租房子");
    }

    @Override
    public void buy() {
        System.out.println("买东西");
    }

    @Override
    public void findJob() {
        System.out.println("月薪20K-50k");
        System.out.println("找工作");
    }
}
