package com.luo.command.remoteWL;

/**
 * 电视
 *
 * @author luoxuzheng
 * @create 2019-09-15 22:13
 **/
public class TV {
    String location;
    int channel;

    public TV(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println("TV is on");
    }

    public void off() {
        System.out.println("TV is off");
    }

    public void setInputChannel() {
        this.channel = 3;
        System.out.println("Channel is set for VCR");
    }
}
