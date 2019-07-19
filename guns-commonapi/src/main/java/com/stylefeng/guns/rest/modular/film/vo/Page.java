package com.stylefeng.guns.rest.modular.film.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @Author IL-M
 * @Date:2019/7/18 23:26
 */
public class Page<T> implements Serializable {


    private static final long serialVersionUID = -6387996992042236453L;

    private int status;
    private String imgPre;
    private int nowPage;
    private int totalPage;
    private List<T> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImgPre() {
        return imgPre;
    }

    public void setImgPre(String imgPre) {
        this.imgPre = imgPre;
    }

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}


