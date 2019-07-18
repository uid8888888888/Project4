package com.stylefeng.guns.rest.modular.user.util;

import com.stylefeng.guns.rest.common.persistence.model.MtimeUserT;
import com.stylefeng.guns.rest.modular.user.bean.UserInfo;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Date;

/**
 * @author YangShuo
 * @date 2019-07-17 23:21
 */
public class UserInfoToMtimeUserT {


    public static MtimeUserT userInfoToMtimeUserT(UserInfo userInfo) {
        MtimeUserT mtimeUserT = new MtimeUserT();

        mtimeUserT.setUuid(userInfo.getUuid());
        mtimeUserT.setUserName(userInfo.getUsername());
        mtimeUserT.setNickName(userInfo.getNickname());
        mtimeUserT.setEmail(userInfo.getEmail());
        mtimeUserT.setUserPhone(userInfo.getPhone());
        mtimeUserT.setUserSex(userInfo.getSex());
        mtimeUserT.setBirthday(userInfo.getBirthday());
        mtimeUserT.setBiography(userInfo.getBiography());
        mtimeUserT.setLifeState(userInfo.getLifeState());
        mtimeUserT.setAddress(userInfo.getAddress());
        mtimeUserT.setHeadUrl(userInfo.getHeadAddress());
        mtimeUserT.setBeginTime(userInfo.getCreateTime());
        mtimeUserT.setUpdateTime(userInfo.getUpdateTime());

        return mtimeUserT;
    }

    public static UserInfo mtimeUserTtoUserInfo(MtimeUserT mtimeUserT){
        Integer uuid = mtimeUserT.getUuid();
        String username = mtimeUserT.getUserName();
        String nickname = mtimeUserT.getNickName();
        String email = mtimeUserT.getEmail();
        String phone = mtimeUserT.getUserPhone();
        Integer sex = mtimeUserT.getUserSex();
        String birthday = mtimeUserT.getBirthday();
        Integer lifeState = mtimeUserT.getLifeState();
        String biography = mtimeUserT.getBiography();
        String address = mtimeUserT.getAddress();
        String headAddress = mtimeUserT.getHeadUrl();

        Date createTime = mtimeUserT.getBeginTime();
        Date updateTime = mtimeUserT.getUpdateTime();

        UserInfo userInfo = new UserInfo(uuid,username,nickname,email,phone,sex,birthday,lifeState,biography,address,headAddress,createTime,updateTime);

        return userInfo;


    }

}
