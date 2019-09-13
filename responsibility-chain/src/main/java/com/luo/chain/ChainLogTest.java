package com.luo.chain;

import com.luo.chain.abst.AbstractLogger;
import com.luo.chain.log.InfoLogger;
import com.luo.chain.log.ErrorLogger;
import com.luo.chain.log.DebugLogger;

/**
 * @author luoxuzheng
 * @create 2019-09-13 14:10
 **/
public class ChainLogTest {
    private static AbstractLogger getChainOfLoggers() {

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger infoLogger = new InfoLogger(AbstractLogger.INFO);
        AbstractLogger debugLogger = new DebugLogger(AbstractLogger.DEBUG);

        errorLogger.setNextLogger(infoLogger);
        infoLogger.setNextLogger(debugLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
//        AbstractLogger loggerChain = getChainOfLoggers();

//        loggerChain.logMessage(AbstractLogger.DEBUG,"This is a information.");

//        loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");

//        loggerChain.logMessage(AbstractLogger.ERROR,"This is an information.");


        //改良
        /**
         * 暴露最低等级既可
         */
//        AbstractLogger logger = new DebugLogger();
        AbstractLogger logger = new InfoLogger();
//        AbstractLogger logger = new ErrorLogger();

        logger.logMessage(3, "错误信息");

        logger.logMessage(2, "测试信息");

        logger.logMessage(1, "控制台信息");
    }
}
