package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.modular.film.vo.FilmInfo;

import java.util.ArrayList;

/**
 * @Author IL-M
 * @Date:2019/7/17 22:57
 */
public interface FilmMapper {
    ArrayList<FilmInfo> oneCatFilmList(Integer showType,Integer sortId,String catId,Integer sourceId,Integer yearId);
    ArrayList<FilmInfo> allCatFilmList(Integer showType,Integer sortId,String catId,Integer sourceId,Integer yearId);
}
