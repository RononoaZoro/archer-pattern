package com.luo.chain;

import com.luo.App;
import com.luo.chain.abst.IRequestProcessor;
import com.luo.chain.processor.*;

/**
 * @author luoxuzheng
 * @create 2019-09-13 14:32
 **/
public class ChainProcessorTest {
    static IRequestProcessor requestProcessor;

    public void setUp() {
        FinalProcessor finalProcessor = new FinalProcessor();
        PrintProcessor printProcessor = new PrintProcessor(finalProcessor);
        SaveProcessor saveProcessor = new SaveProcessor(printProcessor);
        requestProcessor = new PrevProcessor(saveProcessor);
    }

    public static void main(String[] args) {
        ChainProcessorTest app=new ChainProcessorTest();
        app.setUp();
        Request request=new Request();
        request.setName("Archer");
        requestProcessor.process(request);
    }
}
