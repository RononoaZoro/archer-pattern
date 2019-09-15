package com.luo.command.simpleremoteWL;

/**
 * 命令接收者，执行者
 *
 * @author luoxuzheng
 * @create 2019-09-15 21:55
 **/
public class Light {

    public Light() {
    }

    public void on() {
        System.out.println("Light is on");
    }

    public void off() {
        System.out.println("Light is off");
    }
}
