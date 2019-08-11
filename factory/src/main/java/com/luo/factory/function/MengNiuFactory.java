package com.luo.factory.function;

import com.luo.factory.Milk;
import com.luo.factory.bean.MengNiu;

/**
 * 蒙牛工厂
 *
 * @author luoxuzheng
 * @create 2019-08-10 11:42
 **/
public class MengNiuFactory implements Factory {
    @Override
    public Milk getMilk() {
        return new MengNiu();
    }
}

