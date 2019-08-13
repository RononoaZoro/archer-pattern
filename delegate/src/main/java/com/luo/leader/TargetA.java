package com.luo.leader;

/**
 * @author luoxuzheng
 * @create 2019-08-13 17:19
 **/
public class TargetA implements Itarget {
    @Override
    public void doingTask(String command) {
        System.out.println("我是员工A，执行 "+command+"任务");
    }
}
