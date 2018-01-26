package com.example.sinta.myapplication.utility;

/**
 * Created by Sinta Adiyasa on 1/23/2018.
 * Email: sintaadiyasa@gmail.com
 */

public interface Constant {
    interface Api{
        static String BASE_URL = "https://Api.themoviedb.org/3/movie/";
        static String API_KEY = "7f715f5c58878215fe3bbd17c2af69f7";
        static String IMAGE_PATH = "https://image.tmdb.org/t/p/w500";
        String RATING = "\u2605 ";
    }
    interface FragmentChooser{
        static String NOW_PLAYING = "Now Playing";
        static String FAVORITE = "Favorite";
        static String TOP_RATED = "Top Rated";
        static String UPCOMING = "Upcoming";
        static String POPULAR = "Popular";
    }
}
