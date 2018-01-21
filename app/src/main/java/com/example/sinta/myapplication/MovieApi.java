package com.example.sinta.myapplication;

import com.example.sinta.myapplication.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Sinta Adiyasa on 1/21/2018.
 * Email: sintaadiyasa@gmail.com
 */

public interface MovieApi {

    String BASE_URL = "https://api.themoviedb.org/3/movie";
    String API_KEY = App.getInstance().getApplicationContext().getString(R.string.api_key);

    @GET("now_playing")
    Call<MovieResponse> getNowPlaying(@Query("api_key") String apiKey);

    @GET("popular")
    Call<MovieResponse> getPopular(@Query("api_key") String apiKey);

    @GET("upcoming")
    Call<MovieResponse> getUpComing(@Query("api_key") String apiKey);


}
