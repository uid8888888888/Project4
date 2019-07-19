package com.stylefeng.guns.rest.modular.cinema.vo;

import lombok.Data;

@Data
public class FieldResultVo<T> {

    private int status;

    private String imgPre;

    private T data;

}
