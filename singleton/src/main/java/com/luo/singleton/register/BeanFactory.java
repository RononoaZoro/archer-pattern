package com.luo.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Spring的 IoC
 *
 * @author luoxuzheng
 * @create 2019-08-10 17:30
 **/
//Spring中的做法，就是用这种注册式单例
public class BeanFactory {

    private BeanFactory(){}

    //线程安全
    private static Map<String, Object> registerMap = new ConcurrentHashMap<>();

    public static Object getBean(String beanName) {
        synchronized (BeanFactory.class){//spring中也是用synchronized实现线程安全的
            if (!registerMap.containsKey(beanName)) {
                Object obj = null;
                try {
                    obj = Class.forName(beanName).newInstance();
                    registerMap.put(beanName, obj);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                return obj;
            } else {
                return registerMap.get(beanName);
            }
        }
    }
}

