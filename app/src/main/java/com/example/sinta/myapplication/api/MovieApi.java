package com.example.sinta.myapplication.api;

import com.example.sinta.myapplication.model.MovieDetail;
import com.example.sinta.myapplication.utility.App;
import com.example.sinta.myapplication.R;
import com.example.sinta.myapplication.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Sinta Adiyasa on 1/21/2018.
 * Email: sintaadiyasa@gmail.com
 */

public interface MovieApi {

    String BASE_URL = "https://api.themoviedb.org/3/movie/";
    String API_KEY = App.getInstance().getApplicationContext().getString(R.string.api_key);

    @GET("now_playing")
    Call<MovieResponse> getNowPlaying(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("popular")
    Call<MovieResponse> getPopular(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("upcoming")
    Call<MovieResponse> getUpComing(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("top_rated")
    Call<MovieResponse> getTopRated(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("{movie_id}")
    Call<MovieDetail> getDetail(@Path("movie_id") int id, @Query("api_key") String apiKey);


}
