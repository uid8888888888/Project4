package com.stylefeng.guns.rest.modular.user.vo;

/**
 * @author YangShuo
 * @date 2019-07-17 9:51
 */
public class StatusDataAndMsg<T> {
    int status;
    String msg;
    T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
