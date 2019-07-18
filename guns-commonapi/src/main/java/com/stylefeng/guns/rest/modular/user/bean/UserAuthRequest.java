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
    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String getCredenceName() {
        return this.username;
    }

    @Override
    public String getCredenceCode() {
        return this.password;
    }
}
