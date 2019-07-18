package com.stylefeng.guns.rest.modular.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.cskaoyan.filmmodule14.*;
import com.cskaoyan.filmmodule14.Service.FilmDetailService;
import com.stylefeng.guns.rest.common.persistence.dao.SearchFilmDetailMapperFromUid8;
import com.stylefeng.guns.rest.common.persistence.model.MtimeFilmInfoT;
import com.stylefeng.guns.rest.common.persistence.model.MtimeFilmT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@Service(interfaceClass = FilmDetailService.class)
public class FilmDetailServiceImpl implements FilmDetailService {

    @Autowired
    SearchFilmDetailMapperFromUid8 searchFilmDetailMapper;

    @Override
    public FilmDetail getFilmDetailByName(String name) {
        MtimeFilmT film = searchFilmDetailMapper.getFilmByFullName(name);
        MtimeFilmInfoT filmInfo = searchFilmDetailMapper.getFilmInfoById(film.getUUID());
        FilmDetail filmDetail = getFilmDetail(film,filmInfo);
        return filmDetail;
    }


    @Override
    public FilmDetail getFilmDetailById(String id) {
        int i = Integer.parseInt(id);
        MtimeFilmT film = searchFilmDetailMapper.getFilmById(i);
        MtimeFilmInfoT filmInfo = searchFilmDetailMapper.getFilmInfoById(film.getUUID());
        FilmDetail filmDetail = getFilmDetail(film,filmInfo);
        return filmDetail;
    }

    private FilmDetail getFilmDetail(MtimeFilmT film, MtimeFilmInfoT filmInfo) {
        FilmDetail filmDetail = new FilmDetail();
        filmDetail.setFilmName(film.getFilmName());
        filmDetail.setFilmEnName(filmInfo.getFilmEnName());
        filmDetail.setScore(film.getFilmScore());
        filmDetail.setScoreNum(filmInfo.getFilmScoreNum());
        filmDetail.setTotalBox(film.getFilmBoxOffice());
        filmDetail.setImgAddress(film.getImgAddress());

        //info01
        String[] filmCats = film.getFilmCats();
        StringBuffer sb = new StringBuffer();
        for (String filmCat : filmCats) {
            int id = Integer.parseInt(filmCat);
            String category = searchFilmDetailMapper.getCategoryById(id);
            sb.append(category + ",");
        }
        String substring = sb.substring(0, sb.length() - 1);
        filmDetail.setInfo01(substring);

        //info02
        String source = searchFilmDetailMapper.getSourceById(film.getFilmSource());
        String info02Massage = source + "/" + filmInfo.getFilmLength() + "分钟";
        filmDetail.setInfo02(info02Massage);

        //info03
        Timestamp filmTime = film.getFilmTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(filmTime.getTime());
        String time = format.format(date);
        String filmArea = searchFilmDetailMapper.getSourceById(film.getFilmArea());
        String info03Message = time + " " + filmArea + "上映";
        filmDetail.setInfo03(info03Message);

        //info04
        Info04 info04 = new Info04();
        info04.setBiography(filmInfo.getBiography());
        Actors actors = new Actors();
        Actor director = searchFilmDetailMapper.getActorByActorId(filmInfo.getDirectorId());
        List<Actor> actorsByFilmId = searchFilmDetailMapper.getActorsByFilmId(film.getUUID());
        actors.setDirector(director);
        actors.setActors(actorsByFilmId);
        info04.setActors(actors);
        filmDetail.setInfo04(info04);

        //imgVO
        ImgVo imgVo = new ImgVo();
        imgVo.setMainImg(film.getImgAddress());
        String[] filmImgs = filmInfo.getFilmImgs();
        int length = 0;
        if(null != filmImgs){
            if(filmImgs.length > 4){
                length = 4;
            }else{
                length = filmImgs.length;
            }
        }
        switch (length){
            case 4:
                imgVo.setImg04(filmImgs[3]);
            case 3:
                imgVo.setImg03(filmImgs[2]);
            case 2:
                imgVo.setImg02(filmImgs[1]);
            case 1:
                imgVo.setImg01(filmImgs[0]);
            case 0:
            default:
        }
        filmDetail.setImgVo(imgVo);

        filmDetail.setFilmId(film.getUUID());

        return filmDetail;
    }
}
