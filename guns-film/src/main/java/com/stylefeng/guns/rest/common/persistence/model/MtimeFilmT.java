package com.stylefeng.guns.rest.common.persistence.model;

import java.sql.Timestamp;

public class MtimeFilmT {

    private int UUID;
    private String FilmName;
    private int FilmType;
    private String imgAddress;
    private String filmScore;
    private int filmBoxOffice;
    private int filmSource;
    private String[] filmCats;
    private int filmArea;
    private int filmDate;
    private Timestamp filmTime;

    public int getFilmBoxOffice() {
        return filmBoxOffice;
    }

    public void setFilmBoxOffice(int filmBoxOffice) {
        this.filmBoxOffice = filmBoxOffice;
    }

    public int getUUID() {
        return UUID;
    }

    public void setUUID(int UUID) {
        this.UUID = UUID;
    }

    public String getFilmName() {
        return FilmName;
    }

    public void setFilmName(String filmName) {
        FilmName = filmName;
    }

    public int getFilmType() {
        return FilmType;
    }

    public void setFilmType(int filmType) {
        FilmType = filmType;
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public String getFilmScore() {
        return filmScore;
    }

    public void setFilmScore(String filmScore) {
        this.filmScore = filmScore;
    }

    public int getFilmSource() {
        return filmSource;
    }

    public void setFilmSource(int filmSource) {
        this.filmSource = filmSource;
    }

    public String[] getFilmCats() {
        return filmCats;
    }

    public void setFilmCats(String[] filmCats) {
        this.filmCats = filmCats;
    }

    public int getFilmArea() {
        return filmArea;
    }

    public void setFilmArea(int filmArea) {
        this.filmArea = filmArea;
    }

    public int getFilmDate() {
        return filmDate;
    }

    public void setFilmDate(int filmDate) {
        this.filmDate = filmDate;
    }

    public Timestamp getFilmTime() {
        return filmTime;
    }

    public void setFilmTime(Timestamp filmTime) {
        this.filmTime = filmTime;
    }
}
