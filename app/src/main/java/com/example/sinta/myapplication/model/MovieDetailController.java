package com.example.sinta.myapplication.model;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

/**
 * Created by Sinta Adiyasa on 1/25/2018.
 * Email: sintaadiyasa@gmail.com
 */

public class MovieDetailController {
    Realm realm;

    public void insert(MovieDetail movie){
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.insert(movie);
        realm.commitTransaction();
    }

    public List<MovieDetail> getAll(){
        realm = Realm.getDefaultInstance();
        List<MovieDetail> movies = new ArrayList<>();
        movies.addAll(realm.where(MovieDetail.class).findAll());
        return movies;
    }

    public boolean isExist(int id){
        realm = Realm.getDefaultInstance();
        MovieDetail movie;
        movie = realm.where(MovieDetail.class).equalTo("id", id).findFirst();
        if(movie == null) return false;
        else return true;
    }

    public void delete(int id){
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.where(MovieDetail.class).equalTo("id", id).findFirst().deleteFromRealm();
        realm.commitTransaction();
    }

    public MovieDetail getMovie(int id) {
        realm = Realm.getDefaultInstance();
        return realm.where(MovieDetail.class).equalTo("id", id).findFirst();
    }
}