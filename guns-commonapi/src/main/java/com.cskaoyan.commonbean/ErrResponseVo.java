package com.cskaoyan.commonbean;

import java.io.Serializable;

public class ErrResponseVo implements Serializable {

    private static final long serialVersionUID = 2286291722801200318L;
    int status;

    String msg;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static ErrResponseVo tranErr(String msg){
        ErrResponseVo errResponseVo = new ErrResponseVo();
        errResponseVo.status = 1;
        errResponseVo.msg = msg;
        return errResponseVo;
    }

    public static ErrResponseVo sysErr(){
        ErrResponseVo errResponseVo = new ErrResponseVo();
        errResponseVo.status = 999;
        errResponseVo.msg = "系统出现异常，请联系管理员";
        return errResponseVo;
    }
}
