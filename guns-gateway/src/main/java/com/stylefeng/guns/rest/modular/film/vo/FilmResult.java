package com.stylefeng.guns.rest.modular.film.vo;

import java.util.List;

/**
 * @Author IL-M
 * @Date:2019/7/17 23:30
 */
public class FilmResult {
    int status;
    String imgPre;
    int nowPage;
    int totalPage;
    List<FilmInfo> data;

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

    public List<FilmInfo> getData() {
        return data;
    }

    public void setData(List<FilmInfo> data) {
        this.data = data;
    }
}
