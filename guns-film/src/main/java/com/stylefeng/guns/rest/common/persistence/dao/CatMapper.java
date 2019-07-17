package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.modular.film.vo.CatInfo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @Author IL-M
 * @Date:2019/7/17 15:55
 */
@Repository
public interface CatMapper {
    ArrayList<CatInfo> getAllCatInfo();
    ArrayList<CatInfo> getOneCatInfo(int catId);
}
