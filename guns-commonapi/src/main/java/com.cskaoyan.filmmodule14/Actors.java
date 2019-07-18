package com.cskaoyan.filmmodule14;

import java.io.Serializable;
import java.util.List;

public class Actors implements Serializable {

    private static final long serialVersionUID = -8696943773763166337L;
    private Actor director;
    private List<Actor> actors;

    public Actor getDirector() {
        return director;
    }

    public void setDirector(Actor director) {
        this.director = director;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
