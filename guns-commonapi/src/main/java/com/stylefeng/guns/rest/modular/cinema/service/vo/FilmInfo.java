package com.stylefeng.guns.rest.modular.cinema.service.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FilmInfo implements Serializable {

    private static final long serialVersionUID = 6222055515343071996L;

    private Integer filmId;

    private String filmName;

    private String filmLength;

    private String filmType;

    private String filmCats;

    private String actors;

    private String imgAddress;

    private List<FieldInfo> filmFields;
}
