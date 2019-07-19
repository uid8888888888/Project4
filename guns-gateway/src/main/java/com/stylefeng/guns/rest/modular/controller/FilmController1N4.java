package com.stylefeng.guns.rest.modular.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.cskaoyan.commonbean.ErrResponseVo;
import com.cskaoyan.filmmodule14.FilmIndex;
import com.cskaoyan.filmmodule14.ResponseVo4FilmModule1N4;
import com.stylefeng.guns.rest.modular.service.FilmDetailService;
import com.stylefeng.guns.rest.modular.service.FilmIndexService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmController1N4 {

    @Reference(interfaceClass = FilmIndexService.class, check = false)
    FilmIndexService filmIndexService;

    @Reference(interfaceClass = FilmDetailService.class, check = false)
    FilmDetailService filmDetailService;

    @RequestMapping("film/getIndex")
    public Object getIndex(){
        try {
            ResponseVo4FilmModule1N4 responseVo = new ResponseVo4FilmModule1N4();
            FilmIndex filmIndex = new FilmIndex();
            filmIndex.setBanners(filmIndexService.getBanners());
            filmIndex.setBoxRanking(filmIndexService.getBoxRanking());
            filmIndex.setExpectRankiing(filmIndexService.getExpectRanking());
            filmIndex.setHotFilms(filmIndexService.getHotFilms());
            filmIndex.setSoonFilms(filmIndexService.getSoonFilm());
            filmIndex.setTop100(filmIndexService.getTop100());
            return ResponseVo4FilmModule1N4.ok(filmIndex);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ErrResponseVo.sysErr();
    }

    @RequestMapping("film/films")
    public Object searchFilms(int searchType,String searchParam) {
        try {
            if (0 == searchType) {
                return ResponseVo4FilmModule1N4.ok(filmDetailService.getFilmDetailById(searchParam));
            } else if (1 == searchType) {
                return ResponseVo4FilmModule1N4.ok(filmDetailService.getFilmDetailByName(searchParam));
            }
        }catch (Exception e){
            System.out.println(e);
            return ErrResponseVo.sysErr();
        }
        return ErrResponseVo.tranErr("传入参数错误");
    }
}
