package com.cskaoyan.filmmodule14;

import java.io.Serializable;

public class Info04 implements Serializable {
    private static final long serialVersionUID = -3184122290163484392L;
    String biography;
    Actors actors;

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Actors getActors() {
        return actors;
    }

    public void setActors(Actors actors) {
        this.actors = actors;
    }
}
