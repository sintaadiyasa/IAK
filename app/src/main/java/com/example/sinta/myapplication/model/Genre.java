package com.example.sinta.myapplication.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by Sinta Adiyasa on 1/25/2018.
 * Email: sintaadiyasa@gmail.com
 */

public class Genre extends RealmObject {
    @SerializedName("name")
    String genreName;

    public String getGenreName() {
        return genreName;
    }
}
