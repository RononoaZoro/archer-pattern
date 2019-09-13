package com.luo.chain.log;

import com.luo.chain.abst.AbstractLogger;

/**
 * @author luoxuzheng
 * @create 2019-09-13 14:08
 **/
public class InfoLogger extends AbstractLogger {

    public InfoLogger() {
        this.level = AbstractLogger.INFO;
        //指定nextLogger为FileLogger
        setNextLogger(new DebugLogger());
    }

    public InfoLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Info::Logger: " + message);
    }
}
