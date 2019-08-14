package com.luo.Subject;

import com.luo.core.EventListener;

/**
 * @author luoxuzheng
 * @create 2019-08-13 21:06
 **/
public class Subject extends EventListener {

    public void add(){
        System.out.println("调用添加的方法");
        //通常采用动态代理的方式防止代码侵入
        trigger(SubjectEventType.ON_ADD);
    }


    public void delete(){
        System.out.println("调用删除的方法");
        trigger(SubjectEventType.ON_DELETE);
    }
}
