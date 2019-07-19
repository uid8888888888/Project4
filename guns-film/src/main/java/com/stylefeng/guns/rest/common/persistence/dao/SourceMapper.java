package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.modular.film.vo.SourceInfo;

import java.util.ArrayList;

/**
 * @Author IL-M
 * @Date:2019/7/17 16:26
 */

public interface SourceMapper {
    ArrayList<SourceInfo> getAllSourceInfo();
    ArrayList<SourceInfo> getOneSourceInfo(int sourceId);
}
