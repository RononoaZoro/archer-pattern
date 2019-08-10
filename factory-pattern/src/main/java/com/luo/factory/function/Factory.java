package com.luo.factory.function;

import com.luo.factory.Milk;

/**
 * 工厂接口
 *
 * @author luoxuzheng
 * @create 2019-08-10 11:34
 **/
public interface Factory {
    /**
     * 获取牛奶
     * @return
     */
     Milk getMilk();

}
