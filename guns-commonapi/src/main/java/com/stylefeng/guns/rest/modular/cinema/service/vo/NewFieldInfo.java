package com.stylefeng.guns.rest.modular.cinema.service.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class NewFieldInfo implements Serializable {

    private static final long serialVersionUID = 5729809151505777867L;

    private NewFilmInfo filmInfo;

    private CinemaInfo cinemaInfo;

    private HallInfo hallInfo;
}
