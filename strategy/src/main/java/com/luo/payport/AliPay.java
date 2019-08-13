package com.luo.payport;

import com.luo.PayState;

/**
 * @author luoxuzheng
 * @create 2019-08-13 14:55
 **/
public class AliPay implements Payment{
    @Override
    public PayState pay(String userId,double money) {
        System.out.println("欢迎使用支付宝支付");
        System.out.println("查询账户余额，开始扣款");
        return new PayState(200,"支付成功",money);
    }
}
