package com.sapients.movieinfoservice.models;

import org.springframework.stereotype.Component;

@Component
public class Film {
    private String title;
    private String director;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}