package com.stylefeng.guns.rest.modular.cinema.service.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FResultVo implements Serializable {


    private static final long serialVersionUID = -79370168381306678L;

    private CinemaInfo cinemaInfo;

    private List<FilmInfo> filmList;
}
