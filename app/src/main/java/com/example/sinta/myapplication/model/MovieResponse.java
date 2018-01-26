package com.example.sinta.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Sinta Adiyasa on 1/21/2018.
 * Email: sintaadiyasa@gmail.com
 */

public class MovieResponse {
    @SerializedName("results")
    private List<Movie> movies;
    @SerializedName("total_pages")
    private int totalPages;

    public List<Movie> getMovies() {
        return movies;
    }

    public int getTotalPages() {
        return totalPages;
    }
}
