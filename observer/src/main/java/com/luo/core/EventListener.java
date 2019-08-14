package com.luo.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 时间监听
 *
 * @author luoxuzheng
 * @create 2019-08-13 20:50
 **/
public class EventListener {
    //事件注册器
    private Map<Enum,Event> events = new HashMap<>();

    /**
     * 注册事件
     * @param eventType
     * @param target
     * @param callback
     */
    public void addListener(Enum eventType, Object target, Method callback){
        //反射调用方法
        events.put(eventType,new Event(target,callback));
    }

    protected void trigger(Enum call){
        if(!this.events.containsKey(call)) return;
        Event event = this.events.get(call).setTrigger(call.toString());
        event.setSource(this);
        event.setTime(System.currentTimeMillis());
        try {
            event.getCallback().invoke(event.getTarget(),event);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
