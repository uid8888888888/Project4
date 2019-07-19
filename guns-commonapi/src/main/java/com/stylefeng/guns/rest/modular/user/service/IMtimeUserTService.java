package com.stylefeng.guns.rest.modular.user.service;

import com.stylefeng.guns.rest.modular.user.bean.UserAuthRequest;
import com.stylefeng.guns.rest.modular.user.bean.UserInfo;
import com.stylefeng.guns.rest.modular.user.bean.UserRegister;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author yangshuo
 * @since 2019-07-16
 */
public interface IMtimeUserTService {



    //用户注册
    boolean userRegister(UserRegister userRegister);

    //用户名存在验证
    boolean usernameExist(String username);

    //用户名+密码不为空判断
    boolean usernameOrPasswordNull(String username, String password);

    //用户登录验证，验证用户名和密码是否都正确
    boolean validate(UserAuthRequest authRequest);

    //用户信息查询，使用用户名作为查询参数
    UserInfo getUserInfoByName(String usernameFromToken);

    //用户信息修改，使用username(也可以用uuid)
    boolean updateUserInfoById(UserInfo userInfo);

    //用户信息查询，使用用户编号作为查询参数
    UserInfo getUserInfoById(Integer uuid);

    //用户token存入redis,用户之后退出使用
    String jedisStoreToken(String userTokenKey, String token);

    //用户关键信息（如userId）存入redis, 供其他模块使用
    String jedisStoreUserMsg(String username);

    //用户退出时，查redis里是否存在对应的token
    boolean jedisTokenExist(String userTokenKey, String authToken);

    //用户退出时，清除redis里对应token
    boolean jedisTokenClean(String userTokenKey, String authToken);
}
