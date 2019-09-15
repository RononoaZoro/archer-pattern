package com.luo.command.simpleremoteWL;

/**
 * 命令接口(函数式接口，有且只有一个方法的接口)
 *
 * @author luoxuzheng
 * @create 2019-09-15 21:52
 **/
@FunctionalInterface
public interface Command {
    public void execute();

}
