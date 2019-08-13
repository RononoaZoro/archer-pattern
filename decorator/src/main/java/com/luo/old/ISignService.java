package com.luo.old;

/**
 * @author luoxuzheng
 * @create 2019-08-13 20:21
 **/
public interface ISignService {

    public ResultMsg register(Member member);

    public ResultMsg login(Member member);
}
