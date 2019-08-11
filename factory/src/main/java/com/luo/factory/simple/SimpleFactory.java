package com.luo.factory.simple;

import com.luo.factory.Milk;
import com.luo.factory.bean.MengNiu;
import com.luo.factory.bean.TeLunSu;
import com.luo.factory.bean.YiLi;

/**
 * 简单工厂模式
 *
 * @author luoxuzheng
 * @create 2019-08-10 11:03
 **/
public class SimpleFactory {

    public Milk getMilk(String milkName){
        //1、定义变量
        Milk milk = null;

        //2、判空
        if(null == milkName ) milkName = "";

        //3、走业务逻辑
        switch (milkName){
            case "mengniu":
                System.out.println(milkName);
                milk = new MengNiu();
                break;
            case "yili":
                System.out.println(milkName);
                milk = new YiLi();
            break;
            case "telunsu":
                System.out.println(milkName);
                milk = new TeLunSu();
            break;
            default:
                System.out.println("没有你要找的产品");
                milk = null;
        }

        return milk;
    }

}
