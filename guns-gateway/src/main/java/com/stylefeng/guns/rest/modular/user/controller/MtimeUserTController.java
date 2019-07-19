package com.stylefeng.guns.rest.modular.user.controller;


import com.alibaba.dubbo.config.annotation.Reference;

import com.stylefeng.guns.rest.common.persistence.model.User;
import com.stylefeng.guns.rest.config.properties.JwtProperties;
import com.stylefeng.guns.rest.modular.auth.util.JwtTokenUtil;
import com.stylefeng.guns.rest.modular.user.bean.UserInfo;
import com.stylefeng.guns.rest.modular.user.bean.UserRegister;
import com.stylefeng.guns.rest.modular.user.service.IMtimeUserTService;
import com.stylefeng.guns.rest.modular.user.vo.StatusAndMsg;
import com.stylefeng.guns.rest.modular.user.vo.StatusDataAndMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author yangshuo
 * @since 2019-07-16
 */
@Controller
@RequestMapping("/user")
public class MtimeUserTController {

    @Reference(interfaceClass = IMtimeUserTService.class,check = false)
    IMtimeUserTService userTService;

    @Autowired
    JwtProperties jwtProperties;

    @Autowired
    JwtTokenUtil jwtTokenUtil;


    /*用户注册入口*/
    @RequestMapping(value = "/register",method = RequestMethod.POST, params = {"username","password"})
    @ResponseBody
    public StatusAndMsg userRegister(UserRegister userRegister){
        String username = userRegister.getUsername();
        String password = userRegister.getPassword();

        StatusAndMsg statusAndMsg = new StatusAndMsg();
        //如果用户名和密码任一为空
        if (userTService.usernameOrPasswordNull(username,password)){
            statusAndMsg.setStatus(999);
            statusAndMsg.setMsg("系统异常，请联系管理员");
            return statusAndMsg;
        }

        //校验用户名
        boolean flag = userTService.usernameExist(username);
        if (flag){
            statusAndMsg.setStatus(1);
            statusAndMsg.setMsg("用户名已存在");
        }else {
            //用户名不存在，则新增用户
            boolean insert = userTService.userRegister(userRegister);
            if (insert){
                statusAndMsg.setStatus(0);
                statusAndMsg.setMsg("注册成功");
            }else {
                statusAndMsg.setStatus(999);
                statusAndMsg.setMsg("系统异常，请联系管理员");
            }
        }
        return statusAndMsg;

    }



    /*用户名验证入口*/
    @RequestMapping(value = "/check", method = RequestMethod.POST, params = "username")
    @ResponseBody
    public StatusAndMsg usernameCheck(String username){
        //查询用户名是否存在
        StatusAndMsg statusAndMsg = new StatusAndMsg();
        boolean flag = userTService.usernameExist(username);
        if (flag){
            statusAndMsg.setStatus(1);
            statusAndMsg.setMsg("用户名已存在");
        }else {
            statusAndMsg.setStatus(0);
            statusAndMsg.setMsg("验证成功");
        }
        return statusAndMsg;
    }


    /*用户信息查询入口*/
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    @ResponseBody
    public StatusDataAndMsg getUserInformation(HttpServletRequest request){
        StatusDataAndMsg<UserInfo> statusDataAndMsg = new StatusDataAndMsg<>();

        //从request里获取token,进而获取username
        String requestHeader = request.getHeader(jwtProperties.getHeader());
        String authToken = requestHeader.substring(7);
        String usernameFromToken = jwtTokenUtil.getUsernameFromToken(authToken);

        //业务异常
        if (usernameFromToken == null || "".equals(usernameFromToken)){
            statusDataAndMsg.setStatus(1);
            statusDataAndMsg.setMsg("查询失败，用户尚未登录");
            return statusDataAndMsg;
        }

        try {
            UserInfo userInfo = userTService.getUserInfoByName(usernameFromToken);
            //查询成功
            statusDataAndMsg.setData(userInfo);
            statusDataAndMsg.setStatus(0);
        }catch (Exception e){
            //系统异常
            statusDataAndMsg.setStatus(999);
            statusDataAndMsg.setMsg("系统出现异常，请联系管理员");
        }

        return statusDataAndMsg;
    }

    /*用户信息修改入口
    * 请求方式限定：post
    * */
    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST, params = {"uuid"})
    @ResponseBody
    public StatusDataAndMsg updateUserInfo(UserInfo userInfo){
        StatusDataAndMsg<UserInfo> statusDataAndMsg = new StatusDataAndMsg<>();
        boolean update = false;
        try {
            update = userTService.updateUserInfoById(userInfo);
        }catch (Exception e){
            statusDataAndMsg.setStatus(999);
            statusDataAndMsg.setMsg("系统出现异常，请联系管理员");
            return statusDataAndMsg;
        }

        if (update) {
            //update成功，返回查询结果
            UserInfo userInfoReturn =  userTService.getUserInfoById(userInfo.getUuid());
            statusDataAndMsg.setStatus(0);
            statusDataAndMsg.setData(userInfoReturn);

        } else {
            //uodate失败
            statusDataAndMsg.setStatus(1);
            statusDataAndMsg.setMsg("用户信息修改失败");
        }

        return statusDataAndMsg;


    }


    /*
    * 用户退出登录入口
    * */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public StatusAndMsg userLogout(HttpServletRequest request){
        //从request里取token和username，查redis里这个token是否存在
        //从request里获取token,进而获取username
        String requestHeader = request.getHeader(jwtProperties.getHeader());
        String authToken = requestHeader.substring(7);
        String usernameFromToken = jwtTokenUtil.getUsernameFromToken(authToken);

        String userTokenKey = usernameFromToken + "Token";
        StatusAndMsg statusAndMsg = new StatusAndMsg();
        boolean flag = false;
        try {
            flag = userTService.jedisTokenExist(userTokenKey, authToken);
        }catch (Exception e){
            //系统异常
            statusAndMsg.setStatus(999);
            statusAndMsg.setMsg("系统异常，请联系管理员");
            return statusAndMsg;
        }

        if (flag){
            //1.token存在，则清除redis里这个token
            userTService.jedisTokenClean(userTokenKey,authToken);
            statusAndMsg.setStatus(0);
            statusAndMsg.setMsg("成功退出");
        }else {
            //2.token不存在，则为未登录
           /* statusAndMsg.setStatus(1);
            statusAndMsg.setMsg("退出失败，用户尚未登录");*/
            //这里抓包结果跟接口文档不一样，修改如下：
            statusAndMsg.setStatus(700);
            statusAndMsg.setMsg("expire");
        }
        return statusAndMsg;
    }



}

