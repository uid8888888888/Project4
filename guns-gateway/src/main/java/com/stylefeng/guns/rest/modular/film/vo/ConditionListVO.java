package com.stylefeng.guns.rest.modular.film.vo;

import java.util.ArrayList;

/**
 * @Author IL-M
 * @Date:2019/7/16 17:05
 */
public class ConditionListVO {
    ArrayList<CatInfo> catInfo;
    ArrayList<SourceInfo>  sourceInfo;
    ArrayList<YearInfo> yearInfo;

    public ArrayList<CatInfo> getCatInfo() {
        return catInfo;
    }

    public void setCatInfo(ArrayList<CatInfo> catInfo) {
        this.catInfo = catInfo;
    }

    public ArrayList<SourceInfo> getSourceInfo() {
        return sourceInfo;
    }

    public void setSourceInfo(ArrayList<SourceInfo> sourceInfo) {
        this.sourceInfo = sourceInfo;
    }

    public ArrayList<YearInfo> getYearInfo() {
        return yearInfo;
    }

    public void setYearInfo(ArrayList<YearInfo> yearInfo) {
        this.yearInfo = yearInfo;
    }
}
