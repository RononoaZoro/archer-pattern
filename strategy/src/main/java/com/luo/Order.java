package com.luo;

import com.luo.payport.PayType;

/**
 * 订单
 *
 * @author luoxuzheng
 * @create 2019-08-13 14:45
 **/
public class Order {
    private String orderId;
    private double money;
    private String userId;

    public Order() {
    }

    public Order(String orderId, double money, String userId) {
        this.orderId = orderId;
        this.money = money;
        this.userId = userId;
    }

    //这个参数，完全可以用Payment这个接口来代替
    //为什么？

    //完美地解决了switch的过程，不需要在代码逻辑中写switch了
    //更不需要写if    else if
    public PayState pay(PayType payType){
        return payType.get().pay(this.userId,this.money);
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
