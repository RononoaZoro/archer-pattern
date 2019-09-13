package com.luo.chain.log;

import com.luo.chain.abst.AbstractLogger;

/**
 * @author luoxuzheng
 * @create 2019-09-13 14:10
 **/
public class DebugLogger extends AbstractLogger {

    public DebugLogger() {
        this.level = AbstractLogger.DEBUG;
    }

    public DebugLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Debug::Logger: " + message);
    }
}
