package com.example.sinta.myapplication.view;

import com.example.sinta.myapplication.model.MovieDetail;

import java.util.List;

/**
 * Created by Sinta Adiyasa on 1/25/2018.
 * Email: sintaadiyasa@gmail.com
 */

public interface MovieFavoriteView {
    void onDataFound(List<MovieDetail> movies);

    void onNoFavorite();
}
