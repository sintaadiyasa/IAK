package com.example.sinta.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Sinta Adiyasa on 1/21/2018.
 * Email: sintaadiyasa@gmail.com
 */

public class Movie {
    private int id;
    @SerializedName("poster_path")
    private String imagePoster;
    @SerializedName("backdrop_path")
    private String backdrop;
    @SerializedName("vote_average")
    private float rating;
    private String title;

    public String getImagePoster() {
        return imagePoster;
    }

    public String getTitle() {
        return title;
    }

    public String getBackdrop() {
        return backdrop;
    }
    public float getRating() {
        return rating;
    }

    public int getId() {
        return id;
    }

}
