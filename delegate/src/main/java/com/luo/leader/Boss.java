package com.luo.leader;

/**
 * @author luoxuzheng
 * @create 2019-08-13 17:18
 **/
public class Boss {

    public static void main(String[] args) {
        new Leader().dispatchTask("登录");
        new Leader().dispatchTask("加密");
    }
}
