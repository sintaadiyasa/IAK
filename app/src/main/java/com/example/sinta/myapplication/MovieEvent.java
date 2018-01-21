package com.example.sinta.myapplication;

import com.example.sinta.myapplication.model.Movie;

import java.util.List;

/**
 * Created by Sinta Adiyasa on 1/21/2018.
 * Email: sintaadiyasa@gmail.com
 */

public class MovieEvent {
    private boolean success;
    private String message;
    private List<Movie> movieList;

    public MovieEvent(boolean success, List<Movie> movieList ){
        this.success = success;
        this.movieList = movieList;
    }

}
