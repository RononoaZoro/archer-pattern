package com.luo.upgrade;

        import com.luo.old.ISignService;
        import com.luo.old.ResultMsg;

/**
 * @author luoxuzheng
 * @create 2019-08-13 20:23
 **/
public interface ISignForThirdService extends ISignService {

    ResultMsg loginForQQ(String openId);

    ResultMsg loginForWechat(String openId);

    ResultMsg loginForToken(String token);

    ResultMsg loginForTelphone(String telphone,String code);

    ResultMsg loginForRegist(String username,String password);
}
