package com.stylefeng.guns.rest.modular.cinema.service.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Halltype implements Serializable {
    private static final long serialVersionUID = 3798723966063794921L;

    private int halltypeId;

    private String halltypeName;

    @JsonProperty("isActive")
    private boolean isActive;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getHalltypeId() {
        return halltypeId;
    }

    public void setHalltypeId(int halltypeId) {
        this.halltypeId = halltypeId;
    }

    public String getHalltypeName() {
        return halltypeName;
    }

    public void setHalltypeName(String halltypeName) {
        this.halltypeName = halltypeName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
