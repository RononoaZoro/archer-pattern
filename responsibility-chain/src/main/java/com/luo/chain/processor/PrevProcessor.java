package com.luo.chain.processor;

import com.luo.chain.abst.IRequestProcessor;

/**
 * @author luoxuzheng
 * @create 2019-09-13 14:24
 **/
public class PrevProcessor implements IRequestProcessor {

    private IRequestProcessor nextProcessor;

    public PrevProcessor() {
    }

    public PrevProcessor(IRequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    @Override
    public void process(Request request) {
        System.out.println("PrevProcessor处理：" + request + "  start");
        nextProcessor.process(request);
        System.out.println("PrevProcessor处理：" + request + "  end");
    }
}
