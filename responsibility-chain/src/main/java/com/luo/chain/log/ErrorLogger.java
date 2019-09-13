package com.luo.chain.log;

import com.luo.chain.abst.AbstractLogger;

/**
 * @author luoxuzheng
 * @create 2019-09-13 14:09
 **/
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger() {
        this.level = AbstractLogger.ERROR;
        //指定nextLogger为FileLogger
        setNextLogger(new InfoLogger());
    }

    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error::Logger: " + message);
    }
}
