package com.luo.payport;

import com.luo.PayState;

/**
 * @author luoxuzheng
 * @create 2019-08-13 14:54
 **/
public interface Payment {
    PayState pay(String userId,double money);
}
