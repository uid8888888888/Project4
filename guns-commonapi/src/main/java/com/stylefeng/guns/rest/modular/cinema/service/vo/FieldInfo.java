package com.stylefeng.guns.rest.modular.cinema.service.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class FieldInfo implements Serializable {

    private static final long serialVersionUID = -2099646111770490640L;

    private Integer fieldId;

    private String beginTime;

    private String endTime;

    private String language;

    private String hallName;

    private Integer price;
}
