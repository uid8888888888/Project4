package com.stylefeng.guns.rest.modular.cinema.vo;

import com.stylefeng.guns.rest.modular.cinema.service.vo.Area;
import com.stylefeng.guns.rest.modular.cinema.service.vo.Brand;
import com.stylefeng.guns.rest.modular.cinema.service.vo.Halltype;

import java.io.Serializable;
import java.util.List;

public class ConditionVo implements Serializable {

    private static final long serialVersionUID = -5753242104675281779L;

    private List<Brand> brandList;

    private List<Area> areaList;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }

    public List<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }

    public List<Halltype> getHalltypeList() {
        return halltypeList;
    }

    public void setHalltypeList(List<Halltype> halltypeList) {
        this.halltypeList = halltypeList;
    }

    private List<Halltype> halltypeList;
}
