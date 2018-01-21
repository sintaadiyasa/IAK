package com.example.sinta.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Sinta Adiyasa on 1/21/2018.
 * Email: sintaadiyasa@gmail.com
 */

public class MovieResponse {

    @SerializedName("list")
    private List<Movie> movieList;

    public List<Movie> getMovieList() {
        return movieList;
    }
}
