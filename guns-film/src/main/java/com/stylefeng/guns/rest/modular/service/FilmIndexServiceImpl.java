package com.stylefeng.guns.rest.modular.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.cskaoyan.filmmodule14.Banner;
import com.cskaoyan.filmmodule14.FilmInfo;
import com.cskaoyan.filmmodule14.FilmVo;
import com.stylefeng.guns.rest.common.persistence.dao.BannerMapperFromUid8;
import com.stylefeng.guns.rest.common.persistence.dao.FilmInfoMapperFromUid8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
@Service(interfaceClass = FilmIndexService.class)
public class FilmIndexServiceImpl implements FilmIndexService {

    @Autowired
    BannerMapperFromUid8 bannerMapper;

    @Autowired
    FilmInfoMapperFromUid8 filmInfoMapper;

    @Override
    public List<Banner> getBanners() {
        return bannerMapper.getBanners();
    }

    @Override
    public FilmVo getHotFilms() {
        /*FilmVo filmVo = new FilmVo();
        List<FilmInfo> hotFilm = filmInfoMapper.getHotFilm();
        filmVo.setFilmInfo(hotFilm);
        filmVo.setFilmNum(hotFilm.size());*/
        return getFilmVo(filmInfoMapper.getHotFilm());
    }

    @Override
    public FilmVo getSoonFilm() {
        return getFilmVo(filmInfoMapper.getSoonFilm());
    }

    @Override
    public List<FilmInfo> getBoxRanking() {
        return filmInfoMapper.getBoxRanking();
    }

    @Override
    public List<FilmInfo> getExpectRanking() {
        return filmInfoMapper.getExpectRanking();
    }

    @Override
    public List<FilmInfo> getTop100() {
        return filmInfoMapper.getTop100Ranking();
    }

    private FilmVo getFilmVo(List<FilmInfo> list){
        FilmVo filmVo = new FilmVo();
        filmVo.setFilmInfo(list);
        filmVo.setFilmNum(list.size());
        return filmVo;
    }
}
