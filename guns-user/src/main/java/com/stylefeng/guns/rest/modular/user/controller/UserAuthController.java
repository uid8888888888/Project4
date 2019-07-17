package com.stylefeng.guns.rest.modular.user.controller;

import com.stylefeng.guns.rest.modular.auth.controller.dto.AuthRequest;
import com.stylefeng.guns.rest.modular.user.service.IMtimeUserTService;
import com.stylefeng.guns.rest.modular.user.vo.StatusDataAndMsg;
import com.stylefeng.guns.rest.modular.user.vo.TokenAndRandomkey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangShuo
 * @date 2019-07-16 23:34
 *
 * 用户登录验证入口
 */
@RestController
public class UserAuthController {

    @Autowired
    IMtimeUserTService userTService;

    /*yangshuo:
     * 1. method = RequestMethod.POST
     * 2.改返回类型ResponseEntity<?>为StatusAndData
     * 3.改死验证为从数据库取至验证 reqValidator.validate(authRequest)
     *
     * */
    @RequestMapping(value = "/auth", method = RequestMethod.POST, params = {"username","password"})
    public StatusDataAndMsg userLogin(AuthRequest authRequest){
        StatusDataAndMsg<Object> statusDataAndMsg = new StatusDataAndMsg<>();

        //1.判断用户名和密码都正确
        boolean validate = userTService.validate(authRequest);
        if (validate){
            //2.产生token
            try {
                TokenAndRandomkey tokenAndRandomkey = userTService.generateTokenAndRandomkey(authRequest);
                statusDataAndMsg.setData(tokenAndRandomkey);
                statusDataAndMsg.setStatus(0);
            }catch (Exception e){
                //3.产生token失败
                statusDataAndMsg.setStatus(999);
                statusDataAndMsg.setMsg("系统出现异常，请联系管理员");
            }
        }else {
            //用户名或密码错误
            statusDataAndMsg.setStatus(1);
            statusDataAndMsg.setMsg("用户名或密码错误");
        }

        return statusDataAndMsg;
    }
}
