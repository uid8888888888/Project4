package com.stylefeng.guns.rest.modular.cinema.service;

import com.stylefeng.guns.rest.modular.cinema.service.vo.*;

import java.util.List;
import java.util.LongSummaryStatistics;

public interface CinemaService {

    List<CinemaVo> getCinemas(Integer brandId, Integer districtId, Integer hallType, Integer pageSize, Integer nowPage);

    int getCinemasCount(Integer brandId, Integer districtId, Integer hallType);

    List<Brand> getBrands(Integer brandId);

    List<Area> getAreas(Integer areaId);

    List<Halltype> getHalltype(Integer hallType);
}
