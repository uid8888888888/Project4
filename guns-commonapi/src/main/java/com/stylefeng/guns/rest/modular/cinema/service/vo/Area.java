package com.stylefeng.guns.rest.modular.cinema.service.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Area implements Serializable {

    private static final long serialVersionUID = -1779743624160210840L;

    private int areaId;

    private String areaName;

    @JsonProperty("isActive")
    private boolean isActive;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
