package com.example.sinta.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sinta.myapplication.R;
import com.example.sinta.myapplication.activity.MovieDetailActivity;
import com.example.sinta.myapplication.fragment.FavoriteMovieFragment.OnListFragmentInteractionListener;
import com.example.sinta.myapplication.model.MovieDetail;
import com.example.sinta.myapplication.utility.Constant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Sinta Adiyasa on 1/25/2018.
 * Email: sintaadiyasa@gmail.com
 */

public class MovieFavoriteAdapter extends RecyclerView.Adapter<MovieFavoriteAdapter.ViewHolder> {
    private final List<MovieDetail> mValues;
    private final OnListFragmentInteractionListener mListener;
    private Context context;

    public MovieFavoriteAdapter(List<MovieDetail> items, OnListFragmentInteractionListener listener,
                                         Context context) {
        mValues = items;
        mListener = listener;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_movie_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.rating.setText(Constant.Api.RATING + mValues.get(position).getRating());
        holder.title.setText(mValues.get(position).getTitle());
        Glide.with(context).load(Constant.Api.IMAGE_PATH + mValues.get(position).getPoster())
                .into(holder.image);

        holder.rootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    context.startActivity(new Intent(context, MovieDetailActivity.class)
                            .putExtra("id", mValues.get(position).getId()).putExtra("jenis",
                                    Constant.FragmentChooser.FAVORITE));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.root_layout)
        ConstraintLayout rootLayout;
        @BindView(R.id.iv_image)
        ImageView image;
        @BindView(R.id.tv_title)
        TextView title;
        @BindView(R.id.rating)
        TextView rating;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}