package com.example.sinta.myapplication.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by Sinta Adiyasa on 1/25/2018.
 * Email: sintaadiyasa@gmail.com
 */

public class Language extends RealmObject {
    @SerializedName("iso_639_1")
    String languageCode;
    @SerializedName("name")
    String languageName;

    public String getLanguageCode() {
        return languageCode;
    }

    public String getLanguageName() {
        return languageName;
    }
}