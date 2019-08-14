package com.luo.Subject;

import com.luo.core.Event;

/**
 * 观察者--监听Subject
 *
 * @author luoxuzheng
 * @create 2019-08-13 21:07
 **/
public class Observer {
    public void advice(Event event){
        System.out.println("=========触发事件，打印日志========\n" + event);

        /*
         *  类似于js的
         *  input
         *  input.addLisenter("click",function(){
         *
         *
         *  });
         *
         *
         * */
    }
}
