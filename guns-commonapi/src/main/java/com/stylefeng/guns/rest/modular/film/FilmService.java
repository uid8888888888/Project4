package com.stylefeng.guns.rest.modular.film;

import com.stylefeng.guns.rest.modular.film.vo.*;

import java.util.ArrayList;

/**
 * @Author IL-M
 * @Date:2019/7/16 17:01
 */
public interface FilmService {
    ArrayList<CatInfo> getcatInfoByCatId(int catId);
    ArrayList<SourceInfo>  getsourceInfoByCatId(int sourceId);
    ArrayList<YearInfo> getyearInfoByCatId(int yearId);
    Page<FilmInfo> getFilms(FilmRequestVO filmRequest);

}
