package com.stylefeng.guns.rest.modular.user.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author YangShuo
 * @date 2019-07-17 20:29
 */
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 596009679510809415L;
    private Integer uuid;
    private String username;
    private String nickname;
    private String email;
    private String phone;
    private Integer sex;
    private String birthday;
    private Integer lifeState;
    private String biography;
    private String address;
    private String headAddress;
    private Date createTime;
    private Date updateTime;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public UserInfo() {
    }

    public UserInfo(Integer uuid, String username, String nickname, String email, String phone, Integer sex, String birthday, Integer lifeState, String biography, String address, String headAddress, Date createTime, Date updateTime) {
        this.uuid = uuid;
        this.username = username;
        this.nickname = nickname;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
        this.birthday = birthday;
        this.lifeState = lifeState;
        this.biography = biography;
        this.address = address;
        this.headAddress = headAddress;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getLifeState() {
        return lifeState;
    }

    public void setLifeState(Integer lifeState) {
        this.lifeState = lifeState;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHeadAddress() {
        return headAddress;
    }

    public void setHeadAddress(String headAddress) {
        this.headAddress = headAddress;
    }
}
