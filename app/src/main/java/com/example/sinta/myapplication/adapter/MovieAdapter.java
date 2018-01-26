package com.example.sinta.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.sinta.myapplication.R;
import com.example.sinta.myapplication.holder.MovieViewHolder;
import com.example.sinta.myapplication.model.Movie;

import java.util.ArrayList;
import java.util.List;

import static com.example.sinta.myapplication.utility.Constant.Api.IMAGE_PATH;

/**
 * Created by Sinta Adiyasa on 1/22/2018.
 * Email: sintaadiyasa@gmail.com
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder>  {
    private List<Movie> movies;
    private Context context;
    private SetOnItemClickListener setOnItemClickListener;
    private OnLoadMoreListener onLoadMoreListener;

    public MovieAdapter(List<Movie> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    public void setSetOnItemClickListener(SetOnItemClickListener setOnItemClickListener) {
        this.setOnItemClickListener = setOnItemClickListener;
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }

    public SetOnItemClickListener getSetOnItemClickListener() {
        return setOnItemClickListener;
    }

    public OnLoadMoreListener getOnLoadMoreListener() {
        return onLoadMoreListener;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_movie_main, parent, false);
        return new MovieViewHolder(view, parent.getContext(), this);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Movie movie = movies.get(position);
        Glide.with(context).load(IMAGE_PATH + movie.getImagePoster()).into(holder.getImage());
        holder.getTitle().setText(movie.getTitle());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public interface SetOnItemClickListener{
        public void onClick(View view, int position);
    }

    public interface OnLoadMoreListener{
        void onLoadMore();
    }
}
