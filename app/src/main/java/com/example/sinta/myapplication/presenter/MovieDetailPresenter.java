package com.example.sinta.myapplication.presenter;

import com.example.sinta.myapplication.model.MovieDetail;
import com.example.sinta.myapplication.model.MovieDetailController;
import com.example.sinta.myapplication.utility.App;
import com.example.sinta.myapplication.utility.Constant;
import com.example.sinta.myapplication.view.MovieDetailView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Sinta Adiyasa on 1/25/2018.
 * Email: sintaadiyasa@gmail.com
 */

public class MovieDetailPresenter {
    private MovieDetailView view;
    private MovieDetailController controller;

    public MovieDetailPresenter() {
        controller = new MovieDetailController();
    }

    public void loadDetail(int id, String jenis){
        getView().onLoading();
        if(!jenis.equals(Constant.FragmentChooser.  FAVORITE)){
            Call<MovieDetail> call = App.getInstance().getMovieApi().getDetail(id, Constant.Api.API_KEY);
            call.enqueue(new Callback<MovieDetail>() {
                @Override
                public void onResponse(Call<MovieDetail> call, Response<MovieDetail> response) {
                    if(response.isSuccessful()){
                        if (response.body() != null){
                            getView().onLoadData(response.body());
                            getView().onNoLoading();
                        }else {
                            getView().onError("Failed to get movie detail");
                        }
                    }
                }

                @Override
                public void onFailure(Call<MovieDetail> call, Throwable t) {
                    getView().onError("Server Failure: " + t.getMessage());
                }
            });
        }else {
            MovieDetail movie = controller.getMovie(id);
            getView().onLoadData(movie);
            getView().onNoLoading();
        }
    }

    public MovieDetailView getView() {
        return view;
    }

    public void setView(MovieDetailView view) {
        this.view = view;
    }

    public void checkFavorite(int id) {
        getView().setFavorite(controller.isExist(id));
    }

    public void setFavorite(boolean favorite, MovieDetail movie) {
        if(favorite){
            controller.insert(movie);
            getView().setFavorite(true);
        }else {
            controller.delete(movie.getId());
            getView().setFavorite(false);
        }
    }
}