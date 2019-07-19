package com.stylefeng.guns.rest.modular.film.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @Author IL-M
 * @Date:2019/7/16 16:58
 */
public class YearInfo implements Serializable {
    private static final long serialVersionUID = -17570505299681132L;
    private int yearId;
    private String yearName;
    @JsonProperty("isActive")
    private boolean isActive = false;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getYearId() {
        return yearId;
    }

    public void setYearId(int yearId) {
        this.yearId = yearId;
    }

    public String getYearName() {
        return yearName;
    }

    public void setYearName(String yearName) {
        this.yearName = yearName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
