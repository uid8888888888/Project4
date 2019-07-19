package com.stylefeng.guns.rest.modular.film.vo;

/**
 * @Author IL-M
 * @Date:2019/7/16 17:05
 */
public class ConditionListResult {
    private int status;
    private String msg;
    private ConditionListVO data;

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ConditionListVO getData() {
        return data;
    }

    public void setData(ConditionListVO data) {
        this.data = data;
    }
}
