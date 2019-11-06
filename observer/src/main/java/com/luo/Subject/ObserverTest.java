package com.luo.Subject;

import com.luo.core.Event;

import java.lang.reflect.Array;
import java.lang.reflect.Method;

/**
 * 测试
 *
 * @author luoxuzheng
 * @create 2019-08-13 21:13
 **/
public class ObserverTest {
    public static void main(String[] args) {
        try{
            Observer observer = new Observer();
            Method advice = Observer.class.getMethod("advice", new Class[]{
                    Event.class
            });

            //被观察者
            Subject subject = new Subject();
            subject.addListener(SubjectEventType.ON_ADD,observer,advice);
            subject.addListener(SubjectEventType.ON_DELETE,observer,advice);

            subject.add();
            subject.delete();
        }catch (Exception e){
            e.printStackTrace();
        }


        Object[] objs = new Object[2];
        objs[0] = "1";
        objs[1] = new Integer(1);
    }
}
