package com.luo.chain.abst;

import com.luo.chain.processor.Request;

/**
 * @author luoxuzheng
 * @create 2019-09-13 14:22
 **/
public interface IRequestProcessor {

    void process(Request request);
}
