package com.example.sinta.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Sinta Adiyasa on 1/21/2018.
 * Email: sintaadiyasa@gmail.com
 */

public class Movie {
    @SerializedName("poster_path")
    private String imagePoster;
    @SerializedName("title")
    private String title;

    public String getImagePoster() {
        return imagePoster;
    }

    public String getTitle() {
        return title;
    }
}
