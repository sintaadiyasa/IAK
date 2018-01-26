package com.example.sinta.myapplication.presenter;

import com.example.sinta.myapplication.model.MovieDetail;
import com.example.sinta.myapplication.model.MovieDetailController;
import com.example.sinta.myapplication.view.MovieFavoriteView;

import java.util.List;

/**
 * Created by Sinta Adiyasa on 1/25/2018.
 * Email: sintaadiyasa@gmail.com
 */

public class MovieFavoritePresenter {
    MovieFavoriteView view;
    MovieDetailController controller;

    public MovieFavoritePresenter() {
        controller = new MovieDetailController();
    }

    public void loadFavorite(){
        List<MovieDetail> movies = controller.getAll();
        if(movies != null && !movies.isEmpty()){
            getView().onDataFound(movies);
        }else {
            getView().onNoFavorite();
        }
    }

    public MovieFavoriteView getView() {
        return view;
    }

    public void setView(MovieFavoriteView view) {
        this.view = view;
    }
}
