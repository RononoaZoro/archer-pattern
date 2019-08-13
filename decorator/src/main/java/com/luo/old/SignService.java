package com.luo.old;

/**
 * 原有的登录服务
 *
 * @author luoxuzheng
 * @create 2019-08-13 19:50
 **/
public class SignService implements ISignService{

    /**
     * 注册服务
     * @param member
     * @return
     */
    @Override
    public ResultMsg register(Member member){
        System.out.println("注册成功");
        return new ResultMsg(200,"success",null);
    }

    /**
     * 登录服务
     * @param member
     * @return
     */
    @Override
    public ResultMsg login(Member member){
        System.out.println("登录成功");
        return new ResultMsg(200,"success",null);
    }
}
