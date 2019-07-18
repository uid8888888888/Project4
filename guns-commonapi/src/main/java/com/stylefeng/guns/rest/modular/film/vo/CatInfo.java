package com.stylefeng.guns.rest.modular.film.vo;

import java.io.Serializable;

/**
 * @Author IL-M
 * @Date:2019/7/16 16:45
 */
public class CatInfo implements Serializable {

    private static final long serialVersionUID = 7135578036099052681L;
    private int catId;
    private String  catName;
    private boolean isActive;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
