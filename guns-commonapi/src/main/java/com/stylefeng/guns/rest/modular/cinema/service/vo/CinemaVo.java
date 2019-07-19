package com.stylefeng.guns.rest.modular.cinema.service.vo;

import java.io.Serializable;

public class CinemaVo implements Serializable {
    private static final long serialVersionUID = 4664917813658967495L;


    private int uuid;

    private String cinemaName;

    private String address;

    private double minimumPrice;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(double minimumPrice) {
        this.minimumPrice = minimumPrice;
    }
}
