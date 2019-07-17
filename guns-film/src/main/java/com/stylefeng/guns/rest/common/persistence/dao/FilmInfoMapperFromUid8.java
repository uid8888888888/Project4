package com.stylefeng.guns.rest.common.persistence.dao;

import com.cskaoyan.filmmodule14.FilmInfo;

import java.util.List;

public interface FilmInfoMapperFromUid8 {

    List<FilmInfo> getHotFilm();
    List<FilmInfo> getSoonFilm();
    List<FilmInfo> getBoxRanking();
    List<FilmInfo> getExpectRanking();
    List<FilmInfo> getTop100Ranking();

}
