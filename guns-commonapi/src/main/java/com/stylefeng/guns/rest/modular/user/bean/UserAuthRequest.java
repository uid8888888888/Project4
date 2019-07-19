package com.stylefeng.guns.rest.modular.user.bean;

import com.stylefeng.guns.rest.modular.auth.validator.dto.Credence;

import java.io.Serializable;

/**
 * 认证的请求dto
 *
 * @author fengshuonan
 * @Date 2017/8/24 14:00
 */
public class UserAuthRequest implements Credence, Serializable {

    private static final long serialVersionUID = -9178015872455676078L;
    private String userName;
    private String password;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String getCredenceName() {
        return this.userName;
    }

    @Override
    public String getCredenceCode() {
        return this.password;
    }
}
