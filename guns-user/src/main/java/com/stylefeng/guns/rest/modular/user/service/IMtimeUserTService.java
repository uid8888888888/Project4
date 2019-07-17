package com.stylefeng.guns.rest.modular.user.service;

import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.rest.common.persistence.model.MtimeUserT;
import com.baomidou.mybatisplus.service.IService;
import com.stylefeng.guns.rest.modular.auth.controller.dto.AuthRequest;
import com.stylefeng.guns.rest.modular.user.bean.UserRegister;
import com.stylefeng.guns.rest.modular.user.vo.TokenAndRandomkey;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author yangshuo
 * @since 2019-07-16
 */
public interface IMtimeUserTService extends IService<MtimeUserT> {

    //用户注册
    boolean userRegister(UserRegister userRegister);

    //用户名存在验证
    boolean usernameExist(String username);

    //用户名+密码不为空判断
    boolean usernameOrPasswordNull(String username, String password);

    //用户登录验证，验证用户名和密码是否都正确
    boolean validate(AuthRequest authRequest);

    //用户名和密码验证成功后：返回token+randomkey或抛出异常
    TokenAndRandomkey generateTokenAndRandomkey(AuthRequest authRequest) throws GunsException;


}
