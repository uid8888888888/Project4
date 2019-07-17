package com.stylefeng.guns.rest.modular.service;

import com.cskaoyan.filmmodule14.Banner;
import com.cskaoyan.filmmodule14.FilmInfo;
import com.cskaoyan.filmmodule14.FilmVo;

import java.util.List;

public interface FilmIndexService {

    List<Banner> getBanners();

    FilmVo getHotFilms();

    FilmVo getSoonFilm();

    List<FilmInfo> getBoxRanking();

    List<FilmInfo> getExpectRanking();

    List<FilmInfo> getTop100();
}
