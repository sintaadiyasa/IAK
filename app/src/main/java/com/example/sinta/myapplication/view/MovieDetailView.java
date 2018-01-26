package com.example.sinta.myapplication.view;

import com.example.sinta.myapplication.model.MovieDetail;

/**
 * Created by Sinta Adiyasa on 1/25/2018.
 * Email: sintaadiyasa@gmail.com
 */

public interface MovieDetailView {
    void onLoadData(MovieDetail movie);

    void onError(String messsage);

    void setFavorite(boolean favorite);

    void onLoading();

    void onNoLoading();
}
