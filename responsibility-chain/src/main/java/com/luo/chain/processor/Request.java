package com.luo.chain.processor;

/**
 * @author luoxuzheng
 * @create 2019-09-13 14:23
 **/
public class Request {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                '}';
    }
}
