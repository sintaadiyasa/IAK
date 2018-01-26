package com.example.sinta.myapplication.presenter;

import com.example.sinta.myapplication.model.MovieResponse;
import com.example.sinta.myapplication.utility.App;
import com.example.sinta.myapplication.utility.Constant;
import com.example.sinta.myapplication.view.MovieView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.sinta.myapplication.api.MovieApi.API_KEY;

/**
 * Created by Sinta Adiyasa on 1/23/2018.
 * Email: sintaadiyasa@gmail.com
 */

public class MoviePresenter {
    MovieView view;

    public void loadMoviesNowPlaying(int page){
        Call<MovieResponse> call = App.getInstance().getMovieApi().getNowPlaying(API_KEY, page);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if(response.isSuccessful()){
                    if(response.body() != null){
                        getView().setTotalPages(response.body().getTotalPages());
                        if(response.body().getMovies() != null){
                            getView().onMoviesFound(response.body().getMovies());
                        }
                        else {
                            getView().onError("Failed to found movie list");
                        }
                    }
                    else {
                        getView().onError("No Data");
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                getView().onError("Server Failed: " + t.getMessage());
            }
        });
    }

    public void loadMoviesUpcoming(int page){
        Call<MovieResponse> call = App.getInstance().getMovieApi().getPopular(API_KEY, page);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if(response.isSuccessful()){
                    if(response.body() !=null){
                        getView().onMoviesFound(response.body().getMovies());
                    }
                    else {
                        getView().onError("Movie not found");
                    }
                }
                else {
                    getView().onError("No Movie Data");
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                getView().onError("Server Failed: " + t.getMessage());
            }
        });
    }

    public void loadMoviesTopRated(int page){
        Call<MovieResponse> call = App.getInstance().getMovieApi().getTopRated(API_KEY, page);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if(response.isSuccessful()){
                    if(response.body() !=null){
                        getView().onMoviesFound(response.body().getMovies());
                    }
                    else {
                        getView().onError("Movie not found");
                    }
                }
                else {
                    getView().onError("No Movie Data");
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                getView().onError("Server Failed: " + t.getMessage());
            }
        });
    }

    public void loadMoviesPopular(int page){
        Call<MovieResponse> call = App.getInstance().getMovieApi().getPopular(API_KEY, page);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if(response.isSuccessful()){
                    if(response.body() !=null){
                        getView().onMoviesFound(response.body().getMovies());
                    }
                    else {
                        getView().onError("Movie not found");
                    }
                }
                else {
                    getView().onError("No Movie Data");
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                getView().onError("Server Failed: " + t.getMessage());
            }
        });
    }



    public MovieView getView() {
        return view;
    }

    public void setView(MovieView view) {
        this.view = view;
    }

    public void loadMovies(String jenis, int i) {
        switch (jenis){
            case Constant.FragmentChooser.NOW_PLAYING:
                loadMoviesNowPlaying(i);
                break;
            case Constant.FragmentChooser.TOP_RATED:
                loadMoviesTopRated(i);
                break;
            case Constant.FragmentChooser.UPCOMING:
                loadMoviesUpcoming(i);
                break;
            case Constant.FragmentChooser.POPULAR:
                loadMoviesPopular(i);
                break;
        }
    }
}
