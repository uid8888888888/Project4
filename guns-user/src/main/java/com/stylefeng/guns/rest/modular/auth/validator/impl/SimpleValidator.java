package com.stylefeng.guns.rest.modular.auth.validator.impl;

import com.stylefeng.guns.rest.common.persistence.dao.MtimeUserTMapper;
import com.stylefeng.guns.rest.modular.auth.validator.IReqValidator;
import com.stylefeng.guns.rest.modular.auth.validator.dto.Credence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 直接验证账号密码是不是admin
 *
 * @author fengshuonan
 * @date 2017-08-23 12:34
 *
 * 2019-7-17 修改为通过查询guns-user数据库的表验证账号和密码
 */
@Service
public class SimpleValidator implements IReqValidator {

    /*private static String USER_NAME = "admin";

    private static String PASSWORD = "admin";

    @Override
    public boolean validate(Credence credence) {

        String userName = credence.getCredenceName();
        String password = credence.getCredenceCode();

        if (USER_NAME.equals(userName) && PASSWORD.equals(password)) {
            return true;
        } else {
            return false;
        }
    }*/

    @Autowired
    MtimeUserTMapper userTMapper;

    @Override
    public boolean validate(Credence credence) {
        String userName = credence.getCredenceName();
        String password = credence.getCredenceCode();

        int count = userTMapper.countByUsernameAndPassword(userName,password);
        if (count == 0) {
            return false;
        } else {
            return true;
        }
    }

}
