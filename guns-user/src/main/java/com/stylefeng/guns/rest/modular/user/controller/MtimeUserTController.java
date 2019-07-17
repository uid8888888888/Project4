package com.stylefeng.guns.rest.modular.user.controller;


import com.stylefeng.guns.rest.common.persistence.model.MtimeUserT;
import com.stylefeng.guns.rest.modular.user.bean.UserRegister;
import com.stylefeng.guns.rest.modular.user.service.IMtimeUserTService;
import com.stylefeng.guns.rest.modular.user.vo.StatusAndMsg;
import com.stylefeng.guns.rest.modular.user.vo.StatusDataAndMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

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

    @Autowired
    IMtimeUserTService userTService;

    @RequestMapping("/select")
    @ResponseBody
    public MtimeUserT select(Integer id){
        MtimeUserT mtimeUserT = userTService.selectById(id);
        return mtimeUserT;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public String select(@RequestBody MtimeUserT mtimeUserT){
        boolean insert = userTService.insert(mtimeUserT);
        if (insert){
            return "success";
        }else {
            return "fail";
        }
    }


    /*用户注册入口*/
    @RequestMapping(value = "/register",method = RequestMethod.POST)
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
   /* @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    @ResponseBody
    public StatusDataAndMsg userGetInfo(){



    }*/


}

