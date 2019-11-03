package com.luo;

/**
 * 微信登录
 *

 */
public class WeChatLogin implements Login {
    @Override
    public void accept(Visitor visitor) {
        System.out.println(
                visitor.getClass().getSimpleName() +" 通过微信登录");
    }
}
