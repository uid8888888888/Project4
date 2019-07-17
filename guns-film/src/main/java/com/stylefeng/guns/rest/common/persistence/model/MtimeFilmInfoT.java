package com.stylefeng.guns.rest.common.persistence.model;

public class MtimeFilmInfoT {

    int UUID;
    String filmId;
    String filmEnName;
    int filmScoreNum;
    int filmLength;
    String biography;
    int directorId;
    String[] filmImgs;

    public int getUUID() {
        return UUID;
    }

    public void setUUID(int UUID) {
        this.UUID = UUID;
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public String getFilmEnName() {
        return filmEnName;
    }

    public void setFilmEnName(String filmEnName) {
        this.filmEnName = filmEnName;
    }

    public int getFilmScoreNum() {
        return filmScoreNum;
    }

    public void setFilmScoreNum(int filmScoreNum) {
        this.filmScoreNum = filmScoreNum;
    }

    public int getFilmLength() {
        return filmLength;
    }

    public void setFilmLength(int filmLength) {
        this.filmLength = filmLength;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public String[] getFilmImgs() {
        return filmImgs;
    }

    public void setFilmImgs(String[] filmImgs) {
        this.filmImgs = filmImgs;
    }
}
