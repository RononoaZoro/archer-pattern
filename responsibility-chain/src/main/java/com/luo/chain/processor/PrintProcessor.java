package com.luo.chain.processor;

import com.luo.chain.abst.IRequestProcessor;

/**
 * @author luoxuzheng
 * @create 2019-09-13 14:24
 **/
public class PrintProcessor implements IRequestProcessor{
    private IRequestProcessor nextProcessor;

    public PrintProcessor() {
    }

    public PrintProcessor(IRequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    @Override
    public void process(Request request) {

        System.out.println("PrintProcessor处理：" + request + "  start");
        nextProcessor.process(request);
        System.out.println("PrintProcessor处理：" + request + "  end");
    }
}
