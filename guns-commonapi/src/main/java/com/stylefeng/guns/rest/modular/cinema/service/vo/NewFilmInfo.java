package com.stylefeng.guns.rest.modular.cinema.service.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class NewFilmInfo implements Serializable {

    private static final long serialVersionUID = -8320280792510325493L;

    private Integer filmId;

    private String filmName;

    private String filmType;

    private String imgAddress;

    private String filmCats;

    private String filmLength;

}
