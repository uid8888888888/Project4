package com.stylefeng.guns.rest.modular.film;


import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.common.persistence.dao.CatMapper;
import com.stylefeng.guns.rest.common.persistence.dao.FilmMapper;
import com.stylefeng.guns.rest.common.persistence.dao.SourceMapper;
import com.stylefeng.guns.rest.common.persistence.dao.YearMapper;
import com.stylefeng.guns.rest.modular.film.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;

/**
 * @Author IL-M
 * @Date:2019/7/16 17:07
 */
@Component
@Service(interfaceClass = FilmService.class)
public class FilmServiceImpl implements FilmService {

    @Autowired
    CatMapper catMapper;

    @Override
    public ArrayList<CatInfo> getcatInfoByCatId(int catId) {
        ArrayList<CatInfo> catInfos = new ArrayList<>();
        if (catId == 99) {
            catInfos = catMapper.getAllCatInfo();
        } else {
            catInfos = catMapper.getOneCatInfo(catId);
        }
        return catInfos;
    }

    @Autowired
    SourceMapper sourceMapper;

    @Override
    public ArrayList<SourceInfo> getsourceInfoByCatId(int sourceId) {
        ArrayList<SourceInfo> sourceInfos = new ArrayList<>();
        if (sourceId == 99) {
            sourceInfos = sourceMapper.getAllSourceInfo();
        } else {
            sourceInfos = sourceMapper.getOneSourceInfo(sourceId);
        }
        return sourceInfos;
    }

    @Autowired
    YearMapper yearMapper;

    @Override
    public ArrayList<YearInfo> getyearInfoByCatId(int yearId) {
        ArrayList<YearInfo> yearInfos = new ArrayList<>();
        if (yearId == 99) {
            yearInfos = yearMapper.getAllYearInfo();
        } else {
            yearInfos = yearMapper.getOneYearInfo(yearId);
        }
        return yearInfos;
    }

    @Autowired
    FilmMapper filmMapper;

    @Override
    public ArrayList<FilmInfo> getFilms(FilmRequestVO filmRequest) {
        //分页待完成
        ArrayList<FilmInfo> films = null;
        Integer catId = filmRequest.getCatId();
        if(catId==99){
            //忽略catid条件
            String filmCat = catId.toString();
            films = filmMapper.allCatFilmList(filmRequest.getShowType(),
                    filmRequest.getSortId(),filmCat,
                    filmRequest.getSourceId(), filmRequest.getYearId());
        }else{
            String filmCat = catId.toString();
            filmCat = "%#" + filmCat + "#%";
            films = filmMapper.oneCatFilmList(filmRequest.getShowType(),
                    filmRequest.getSortId(),filmCat,
                    filmRequest.getSourceId(), filmRequest.getYearId());
        }
        return films;

    }


}
