package com.cskaoyan.filmmodule14;

import java.io.Serializable;

public class ResponseVo4FilmModule1N4 implements Serializable {
    private static final long serialVersionUID = 7418792417126978473L;
    int status;

    String imgPre;

    Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResponseVo4FilmModule1N4 ok(Object data){
        ResponseVo4FilmModule1N4 responseVo = new ResponseVo4FilmModule1N4();
        responseVo.setImgPre("http://img.meetingshop.cn/");
        responseVo.setStatus(0);
        responseVo.setData(data);
        return responseVo;
    }
}
