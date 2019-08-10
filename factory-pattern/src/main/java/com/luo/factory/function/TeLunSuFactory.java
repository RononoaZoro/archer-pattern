package com.luo.factory.function;

import com.luo.factory.Milk;
import com.luo.factory.bean.TeLunSu;

/**
 * 特仑苏工厂
 *
 * @author luoxuzheng
 * @create 2019-08-10 11:43
 **/
public class TeLunSuFactory implements Factory{
    @Override
    public Milk getMilk() {
        return new TeLunSu();
    }
}
