package com.stylefeng.guns.rest.modular.cinema.service.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class CinemaInfo implements Serializable {

    private static final long serialVersionUID = -3462650370809195734L;

    private Integer cinemaId;

    private String imgUrl;

    private String cinemaName;

    private String cinemaAdress;

    private String cinemaPhone;

}
