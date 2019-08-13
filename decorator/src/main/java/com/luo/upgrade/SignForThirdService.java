package com.luo.upgrade;

import com.luo.old.ISignService;
import com.luo.old.Member;
import com.luo.old.ResultMsg;

/**
 * @author luoxuzheng
 * @create 2019-08-13 20:24
 **/
public class SignForThirdService implements ISignForThirdService {
    private ISignService iSignService;

    public SignForThirdService(ISignService iSignService) {
        this.iSignService = iSignService;
    }

    @Override
    public ResultMsg loginForQQ(String openId) {
        //todo 写新功能
        return null;
    }

    @Override
    public ResultMsg loginForWechat(String openId) {
        return null;
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return null;
    }

    @Override
    public ResultMsg loginForTelphone(String telphone, String code) {
        return null;
    }

    @Override
    public ResultMsg loginForRegist(String username, String password) {
        return null;
    }

    @Override
    public ResultMsg register(Member member) {
        System.out.println("实现原有注册逻辑");
        return iSignService.register(member);
    }

    @Override
    public ResultMsg login(Member member) {
        System.out.println("实现原有登录逻辑");
        return iSignService.login(member);
    }
}
