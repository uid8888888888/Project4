package com.stylefeng.guns.rest.modular.cinema.vo;

public class ConditionResultVo<T> {

    private int status;

    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
