package com.stylefeng.guns.rest.modular.test;

import com.cskaoyan.commonbean.ErrResponseVo;
import com.cskaoyan.filmmodule14.FilmDetail;
import com.cskaoyan.filmmodule14.FilmIndex;
import com.cskaoyan.filmmodule14.ResponseVo4FilmModule1N4;
import com.cskaoyan.filmmodule14.Service.FilmDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    FilmDetailService filmDetailService;
   /* @Autowired
    FilmIndexService filmIndexService;

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
    }*/

    /*@RequestMapping("film/films")
    public Object searchFilms(int searchType,String searchParam){
        if(0 == searchType){
            return filmDetailService.getFilmDetailById(searchParam);
        } else if (1 == searchType) {
            return filmDetailService.getFilmDetailByName(searchParam);
        }
        return ErrResponseVo.tranErr("传入参数错误");
    }*/
}
