package com.example.sinta.myapplication.view;

import com.example.sinta.myapplication.model.Movie;

import java.util.List;

/**
 * Created by Sinta Adiyasa on 1/23/2018.
 * Email: sintaadiyasa@gmail.com
 */

public interface MovieView {
    void onMoviesFound(List<Movie> movies);

    void setTotalPages(int pages);

    void onError(String message);
}
