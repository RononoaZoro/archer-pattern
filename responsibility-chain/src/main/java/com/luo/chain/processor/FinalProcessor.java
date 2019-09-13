package com.luo.chain.processor;

import com.luo.chain.abst.IRequestProcessor;

/**
 * @author luoxuzheng
 * @create 2019-09-13 14:24
 **/
public class FinalProcessor implements IRequestProcessor{
    private IRequestProcessor nextProcessor;

    public FinalProcessor() {
    }

    public FinalProcessor(IRequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    @Override
    public void process(Request request) {
        System.out.println("FinalProcessor处理：" + request + "  start");

        if(nextProcessor!=null) {
            nextProcessor.process(request);
        }

        System.out.println("FinalProcessor处理：" + request + "  end");
    }
}
