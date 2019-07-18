package com.stylefeng.guns.rest.modular.user.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.core.util.MD5Util;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeUserTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimeUserT;
import com.stylefeng.guns.rest.modular.auth.util.JwtTokenUtil;
import com.stylefeng.guns.rest.modular.auth.validator.IReqValidator;
import com.stylefeng.guns.rest.modular.user.bean.UserAuthRequest;
import com.stylefeng.guns.rest.modular.user.bean.UserInfo;
import com.stylefeng.guns.rest.modular.user.bean.UserRegister;
import com.stylefeng.guns.rest.modular.user.util.Md5Util;
import com.stylefeng.guns.rest.modular.user.util.UserInfoToMtimeUserT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author yangshuo
 * @since 2019-07-16
 */
@Component
@Service(interfaceClass = IMtimeUserTService.class)
public class MtimeUserTServiceImpl implements IMtimeUserTService {

    @Autowired
    MtimeUserTMapper userTMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Resource(name = "simpleValidator")
    private IReqValidator reqValidator;



    @Override
    public boolean userRegister(UserRegister userRegister) {
        String username = userRegister.getUsername();
        String password = userRegister.getPassword();
        String email = userRegister.getEmail();
        String phone = userRegister.getPhone();
        String address = userRegister.getAddress();

        //密码需要先加密再存入数据库
        password = Md5Util.getMD5(password);

        MtimeUserT mtimeUserT = new MtimeUserT(username,password,email,phone,address);
        Integer insert = userTMapper.insert(mtimeUserT);
        if (insert == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean usernameExist(String username) {
        int i = userTMapper.countByUsername(username);
        if (i == 0){
            return false;
        }
        return true;
    }

    @Override
    public boolean usernameOrPasswordNull(String username, String password) {
        if (username == null || "".equals(username) || password == null || "".equals(password)){
            return true;
        }
        return false;
    }


    @Override
    public boolean validate(UserAuthRequest authRequest) {
        boolean validate = reqValidator.validate(authRequest);
        return validate;
    }

    @Override
    public UserInfo getUserInfoByName(String usernameFromToken) {
        MtimeUserT mtimeUserT = userTMapper.selectByUsername(usernameFromToken);
        UserInfo userInfo = UserInfoToMtimeUserT.mtimeUserTtoUserInfo(mtimeUserT);
        return userInfo;

    }

    @Override
    public boolean updateUserInfoById(UserInfo userInfo) {
        MtimeUserT mtimeUserT = UserInfoToMtimeUserT.userInfoToMtimeUserT(userInfo);
        Integer update = userTMapper.updateById(mtimeUserT);

        if (update == 1){
            return true;
        }else {
            return false;
        }
    }


    @Override
    public UserInfo getUserInfoById(Integer uuid) {
        MtimeUserT mtimeUserT = userTMapper.selectById(uuid);
        UserInfo userInfo = UserInfoToMtimeUserT.mtimeUserTtoUserInfo(mtimeUserT);
        return userInfo;
    }


}
