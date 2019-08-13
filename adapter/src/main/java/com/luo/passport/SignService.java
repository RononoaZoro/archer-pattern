package com.luo.passport;

import com.luo.Member;
import com.luo.ResultMsg;

/**
 * 原有的登录服务
 *
 * @author luoxuzheng
 * @create 2019-08-13 19:50
 **/
public class SignService {

    /**
     * 注册服务
     * @param member
     * @return
     */
    public ResultMsg register(Member member){
        System.out.println("注册成功");
        return new ResultMsg(200,"success",null);
    }

    /**
     * 登录服务
     * @param member
     * @return
     */
    public ResultMsg login(Member member){
        System.out.println("登录成功");
        return new ResultMsg(200,"success",null);
    }
}
