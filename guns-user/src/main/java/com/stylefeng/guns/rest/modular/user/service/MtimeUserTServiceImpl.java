package com.stylefeng.guns.rest.modular.user.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeUserTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimeUserT;
import com.stylefeng.guns.rest.modular.auth.util.JwtTokenUtil;
import com.stylefeng.guns.rest.modular.auth.validator.IReqValidator;
import com.stylefeng.guns.rest.modular.user.bean.UserAuthRequest;
import com.stylefeng.guns.rest.modular.user.bean.UserInfo;
import com.stylefeng.guns.rest.modular.user.bean.UserRegister;
import com.stylefeng.guns.rest.modular.user.util.JedisUtil;
import com.stylefeng.guns.rest.modular.user.util.Md5Util;
import com.stylefeng.guns.rest.modular.user.util.UserInfoToMtimeUserT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

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

    @Override
    public String jedisStoreToken(String userTokenKey, String token) {
        Jedis jedis = JedisUtil.getJedisFromPool();
        //String result = jedis.set(userTokenKey, token);
        //token在redis里的过期时间设为10分钟
        String result = jedis.setex(userTokenKey,600, token);
        jedis.close();

        return result;
    }

    @Override
    public String jedisStoreUserMsg(String username) {
        //1.查出该用户的信息
        MtimeUserT mtimeUserT = userTMapper.selectByUsername(username);
        //2.将用户信息转换成json格式数据(使用fastjson)
        String jsonOfUsermsg = JSON.toJSONString(mtimeUserT);
        System.out.println("jsonOfUsermsg = " + jsonOfUsermsg);

        //3.存入redis里，key=username,value=json字符串，有效期1天
        Jedis jedis = JedisUtil.getJedisFromPool();
        //String result = jedis.set(username, jsonOfUsermsg);
        String result = jedis.setex(username,86400,jsonOfUsermsg);

        jedis.close();
        return result;
    }

    @Override
    public boolean jedisTokenExist(String userTokenKey, String authToken) {
        Jedis jedis = JedisUtil.getJedisFromPool();
        String tokenInRedis = jedis.get(userTokenKey);
        if (authToken.equals(tokenInRedis)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean jedisTokenClean(String userTokenKey, String authToken) {
        Jedis jedis = JedisUtil.getJedisFromPool();
        String result = jedis.setex(userTokenKey, 1, authToken);
        if ("OK".equalsIgnoreCase(result)){
            return true;
        }
        return false;
    }


    private Integer getUseridByName(String username) {
        Integer uuid =  userTMapper.getUseridByName(username);
        return uuid;
    }


}
