package com.example.sinta.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Sinta Adiyasa on 1/25/2018.
 * Email: sintaadiyasa@gmail.com
 */

public class MovieDetail extends RealmObject {
    private int id;
    @SerializedName("backdrop_path")
    private String header;
    @SerializedName("original_title")
    private String title;
    @SerializedName("overview")
    private String description;
    @SerializedName("poster_path")
    private String poster;
    @SerializedName("release_date")
    private Date date;
    @SerializedName("vote_average")
    private double rating;
    @SerializedName("runtime")
    private int duration;
    private RealmList<Genre> genres;
    @SerializedName("spoken_languages")
    private RealmList<Language> language;

    public int getId() {
        return id;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public List<Language> getLanguage() {
        return language;
    }

    public String getHeader() {
        return header;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPoster() {
        return poster;
    }

    public Date getDate() {
        return date;
    }

    public double getRating() {
        return rating;
    }

    public int getDuration() {
        return duration;
    }
}