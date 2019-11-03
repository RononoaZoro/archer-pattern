package com.luo;

/**
 * TODO...
 *

 */
public class QQLogin implements Login {

    @Override
    public void accept(Visitor visitor) {
        System.out.println(
                visitor.getClass().getSimpleName() + " 通过QQ登录");
    }
}
