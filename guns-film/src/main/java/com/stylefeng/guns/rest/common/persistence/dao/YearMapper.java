package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.modular.film.vo.YearInfo;

import java.util.ArrayList;

/**
 * @Author IL-M
 * @Date:2019/7/17 16:26
 */

public interface YearMapper {
    ArrayList<YearInfo> getAllYearInfo();
    ArrayList<YearInfo> getOneYearInfo(int yearId);
}
