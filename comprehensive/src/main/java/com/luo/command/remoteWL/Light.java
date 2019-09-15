package com.luo.command.remoteWL;

/**
 * 灯
 * @author luoxuzheng
 * @create 2019-09-15 22:12
 **/
public class Light {
    String location = "";

    public Light(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " light is on");
    }

    public void off() {
        System.out.println(location + " light is off");
    }
}
