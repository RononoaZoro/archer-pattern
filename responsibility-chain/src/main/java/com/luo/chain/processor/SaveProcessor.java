package com.luo.chain.processor;

import com.luo.chain.abst.IRequestProcessor;
import com.luo.chain.processor.Request;

/**
 * @author luoxuzheng
 * @create 2019-09-13 14:24
 **/
public class SaveProcessor implements IRequestProcessor {

    private IRequestProcessor nextProcessor;

    public SaveProcessor() {
    }

    public SaveProcessor(IRequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    @Override
    public void process(Request request) {
        System.out.println("SaveProcessor处理：" + request + "  start");
        nextProcessor.process(request);
        System.out.println("SaveProcessor处理：" + request + "  end");
    }
}
