package com.luo.command.simpleremote;

/**
 * 命令接口
 *
 * @author luoxuzheng
 * @create 2019-09-15 21:52
 **/
@FunctionalInterface
public interface Command {
    public void execute();
}
