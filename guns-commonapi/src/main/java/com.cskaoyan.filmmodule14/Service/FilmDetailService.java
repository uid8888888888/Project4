package com.cskaoyan.filmmodule14.Service;

import com.cskaoyan.filmmodule14.FilmDetail;

public interface FilmDetailService {

    FilmDetail getFilmDetailByName(String name);

    FilmDetail getFilmDetailById(String id);
}
