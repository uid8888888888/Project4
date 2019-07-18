package com.cskaoyan.filmmodule14;

import java.io.Serializable;
import java.util.List;

public class FilmIndex implements Serializable {

    private static final long serialVersionUID = 7108424615540137021L;
    private List<Banner> banners;
    private FilmVo hotFilms;
    private FilmVo soonFilms;
    private List<FilmInfo> boxRanking;
    private List<FilmInfo> expectRankiing;
    private List<FilmInfo> top100;

    public List<Banner> getBanners() {
        return banners;
    }

    public void setBanners(List<Banner> banners) {
        this.banners = banners;
    }

    public FilmVo getHotFilms() {
        return hotFilms;
    }

    public void setHotFilms(FilmVo hotFilms) {
        this.hotFilms = hotFilms;
    }

    public FilmVo getSoonFilms() {
        return soonFilms;
    }

    public void setSoonFilms(FilmVo soonFilms) {
        this.soonFilms = soonFilms;
    }

    public List<FilmInfo> getBoxRanking() {
        return boxRanking;
    }

    public void setBoxRanking(List<FilmInfo> boxRanking) {
        this.boxRanking = boxRanking;
    }

    public List<FilmInfo> getExpectRankiing() {
        return expectRankiing;
    }

    public void setExpectRankiing(List<FilmInfo> expectRankiing) {
        this.expectRankiing = expectRankiing;
    }

    public List<FilmInfo> getTop100() {
        return top100;
    }

    public void setTop100(List<FilmInfo> top100) {
        this.top100 = top100;
    }
}
