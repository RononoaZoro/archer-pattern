package com.luo.factory.abstr;

import com.luo.factory.Milk;

/**
 * 抽象工厂
 *
 * @author luoxuzheng
 * @create 2019-08-10 11:56
 **/
public abstract class AbstractFactory {

    /**
     * 获取蒙牛
     * @return
     */
    public abstract Milk getMengNiu();

    /**
     * 获取伊利
     * @return
     */
    public abstract Milk getYiLi();

    /**
     * 获取特仑苏
     * @return
     */
    public abstract Milk getTeLunSu();
}
