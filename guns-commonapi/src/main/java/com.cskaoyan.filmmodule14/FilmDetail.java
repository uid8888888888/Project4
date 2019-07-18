package com.cskaoyan.filmmodule14;

import java.io.Serializable;

public class FilmDetail implements Serializable {

    private static final long serialVersionUID = -7835942686851682612L;
    private String filmName;
    private String filmEnName;
    private String imgAddress;
    private String score;
    private int scoreNum;
    private int totalBox;
    private String info01;
    private String info02;
    private String info03;
    private Info04 info04;
    private ImgVo imgVo;
    private int filmId;

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmEnName() {
        return filmEnName;
    }

    public void setFilmEnName(String filmEnName) {
        this.filmEnName = filmEnName;
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getScoreNum() {
        return scoreNum;
    }

    public void setScoreNum(int scoreNum) {
        this.scoreNum = scoreNum;
    }

    public int getTotalBox() {
        return totalBox;
    }

    public void setTotalBox(int totalBox) {
        this.totalBox = totalBox;
    }

    public String getInfo01() {
        return info01;
    }

    public void setInfo01(String info01) {
        this.info01 = info01;
    }

    public String getInfo02() {
        return info02;
    }

    public void setInfo02(String info02) {
        this.info02 = info02;
    }

    public String getInfo03() {
        return info03;
    }

    public void setInfo03(String info03) {
        this.info03 = info03;
    }

    public Info04 getInfo04() {
        return info04;
    }

    public void setInfo04(Info04 info04) {
        this.info04 = info04;
    }

    public ImgVo getImgVo() {
        return imgVo;
    }

    public void setImgVo(ImgVo imgVo) {
        this.imgVo = imgVo;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }
}
