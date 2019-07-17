package com.stylefeng.guns.rest.modular.user.service.impl;

import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.rest.common.exception.BizExceptionEnum;
import com.stylefeng.guns.rest.common.persistence.model.MtimeUserT;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeUserTMapper;
import com.stylefeng.guns.rest.modular.auth.controller.dto.AuthRequest;
import com.stylefeng.guns.rest.modular.auth.util.JwtTokenUtil;
import com.stylefeng.guns.rest.modular.auth.validator.IReqValidator;
import com.stylefeng.guns.rest.modular.user.bean.UserRegister;
import com.stylefeng.guns.rest.modular.user.service.IMtimeUserTService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stylefeng.guns.rest.modular.user.vo.TokenAndRandomkey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author yangshuo
 * @since 2019-07-16
 */
@Service
public class MtimeUserTServiceImpl extends ServiceImpl<MtimeUserTMapper, MtimeUserT> implements IMtimeUserTService {

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

        MtimeUserT mtimeUserT = new MtimeUserT(username,password,email,phone,address);
        boolean insert = this.insert(mtimeUserT);
        return insert;
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
    public boolean validate(AuthRequest authRequest) {
        boolean validate = reqValidator.validate(authRequest);
        return validate;
    }

    @Override
    public TokenAndRandomkey generateTokenAndRandomkey(AuthRequest authRequest) throws GunsException {
        try {
            final String randomKey = jwtTokenUtil.getRandomKey();
            final String token = jwtTokenUtil.generateToken(authRequest.getUsername(), randomKey);
            TokenAndRandomkey tokenAndRandomkey = new TokenAndRandomkey();
            tokenAndRandomkey.setToken(token);
            tokenAndRandomkey.setRandomKey(randomKey);
            return tokenAndRandomkey;
        } catch (Exception e){
            throw new GunsException(BizExceptionEnum.AUTH_REQUEST_ERROR);
        }
    }
}
