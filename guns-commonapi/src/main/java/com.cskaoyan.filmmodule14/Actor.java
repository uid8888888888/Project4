package com.cskaoyan.filmmodule14;

import java.io.Serializable;

public class Actor implements Serializable {

    private static final long serialVersionUID = 4264445972601226391L;
    String imgAddresss;
    String directorName;
    String roleName;

    public String getImgAddresss() {
        return imgAddresss;
    }

    public void setImgAddresss(String imgAddresss) {
        this.imgAddresss = imgAddresss;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
