package com.stylefeng.guns.rest.modular.cinema.service.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Brand implements Serializable {

    private static final long serialVersionUID = -7948115273159107592L;

    private int brandId;

    private String brandName;

    @JsonProperty("isActive")
    private boolean isActive;

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
