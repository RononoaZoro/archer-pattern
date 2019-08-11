package com.luo.factory.function;

import com.luo.factory.Milk;
import com.luo.factory.bean.YiLi;

/**
 * 伊利工厂
 *
 * @author luoxuzheng
 * @create 2019-08-10 11:40
 **/
public class YiLiFactory implements Factory {
    @Override
    public Milk getMilk() {
        return new YiLi();
    }
}
