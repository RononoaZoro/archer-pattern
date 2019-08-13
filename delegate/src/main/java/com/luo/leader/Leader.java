package com.luo.leader;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luoxuzheng
 * @create 2019-08-13 17:19
 **/
public class Leader {
    private Map<String,Itarget> targets = new HashMap<>();

    public Leader() {
        targets.put("加密",new TargetA());
        targets.put("登录",new TargetB());
    }

    public void dispatchTask(String command){
        targets.get(command).doingTask(command);
    }
}
