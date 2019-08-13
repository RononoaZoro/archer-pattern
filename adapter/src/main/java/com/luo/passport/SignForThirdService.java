package com.luo.passport;

import com.luo.Member;
import com.luo.ResultMsg;

/**
 * @author luoxuzheng
 * @create 2019-08-13 19:53
 **/
public class SignForThirdService extends SignService {

    //也可以用组合的方式替代继承，可以利用适配器模式加上策略模式完成需求
    private ILoginForThird iLoginForThird;


    public ResultMsg loginForQQ(String openId){
        //1、openId是全局唯一，我们可以把它当做是一个用户名(加长)
        //2、密码默认为QQ_EMPTY
        //3、注册（在原有系统里面创建一个用户）

        //4、调用原来的登录方法

        return loginForRegist(openId,null);
    }

    public ResultMsg loginForWechat(String openId){
        return null;
    }

    public ResultMsg loginForToken(String token){
        //通过token拿到用户信息，然后再重新登陆了一次
        return  null;
    }

    public ResultMsg loginForTelphone(String telphone,String code){

        return null;
    }

    public ResultMsg loginForRegist(String username,String password){
        Member member = new Member();
        member.setUsername(username);
        member.setPassword(null);
        super.register(member);
        return super.login(member);
    }
}
