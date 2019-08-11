package com.luo.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author luoxuzheng
 * @create 2019-08-10 17:38
 **/
public class RegisterMap {
    private RegisterMap(){}

    private static Map<String,Object> registerMap = new ConcurrentHashMap<>();

    public RegisterMap getInstance(String name){
        if(name == null){
            name = RegisterMap.class.getName();
        }
        if(registerMap.get(name) == null){
            registerMap.put(name,new RegisterMap());
        }

        return (RegisterMap) registerMap.get(name);
    }
}
