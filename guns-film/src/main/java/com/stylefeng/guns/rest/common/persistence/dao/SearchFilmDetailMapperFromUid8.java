package com.stylefeng.guns.rest.common.persistence.dao;

import com.cskaoyan.filmmodule14.Actor;
import com.stylefeng.guns.rest.common.persistence.model.MtimeFilmInfoT;
import com.stylefeng.guns.rest.common.persistence.model.MtimeFilmT;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SearchFilmDetailMapperFromUid8 {

    MtimeFilmT getFilmByFullName(@Param("name") String name);

    MtimeFilmT getFilmById(@Param("id") int id);

    MtimeFilmInfoT getFilmInfoById(@Param("id") int id);

    List<Actor> getActorsByFilmId(@Param("id") int id);

    String getCategoryById(@Param("id") int id);

    String getSourceById(@Param("id") int id);

    Actor getActorByActorId(@Param("id") int id);
}
