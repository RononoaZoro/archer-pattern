package com.luo.payport;

/**
 * 支付类型
 *
 * @author luoxuzheng
 * @create 2019-08-13 14:53
 **/
public enum PayType {
    JD_PAY(new JDPay()),ALI_PAY(new AliPay()),WECHAT_PAY(new WeChatPay()),
    UNION_PAY(new UnionPay());

    private Payment payment;
    PayType(Payment payment){
        this.payment = payment;
    }

    public Payment get(){ return  this.payment;}
}
