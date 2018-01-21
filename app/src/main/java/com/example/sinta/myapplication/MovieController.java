package com.example.sinta.myapplication;

import android.util.Log;

import com.example.sinta.myapplication.model.Movie;
import com.example.sinta.myapplication.model.MovieResponse;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Sinta Adiyasa on 1/21/2018.
 * Email: sintaadiyasa@gmail.com
 */

public class MovieController {

    private static final String TAG = "MovieController";
    private EventBus eventBus = App.getInstance().getEventBus();

    public void getMovieList(){
        Call<MovieResponse> movieResponse = App.getInstance().getMovieApi().getNowPlaying(MovieApi.API_KEY);
        movieResponse.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                Log.d(TAG, "onResponse: Success");
                Log.d(TAG, "onResponse: JSON = " + App.getInstance().getGson().toJson(response.body()));
                List<Movie> movieList=response.body().getMovieList();

            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });
    }
}
