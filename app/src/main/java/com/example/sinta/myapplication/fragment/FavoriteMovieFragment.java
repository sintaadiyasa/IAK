package com.example.sinta.myapplication.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.sinta.myapplication.R;
import com.example.sinta.myapplication.adapter.MovieFavoriteAdapter;
import com.example.sinta.myapplication.model.MovieDetail;
import com.example.sinta.myapplication.presenter.MovieFavoritePresenter;
import com.example.sinta.myapplication.view.MovieFavoriteView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Sinta Adiyasa on 1/25/2018.
 * Email: sintaadiyasa@gmail.com
 */

public class FavoriteMovieFragment extends Fragment implements MovieFavoriteView {
    private MovieFavoritePresenter presenter;
    private Context context;
    private OnListFragmentInteractionListener mListener;
    @BindView(R.id.no_favorite)
    RelativeLayout noFavorite;
    @BindView(R.id.list)
    RecyclerView recyclerView;

    public FavoriteMovieFragment(){

    }

    @SuppressWarnings("unused")
    public static FavoriteMovieFragment newInstance() {
        FavoriteMovieFragment fragment = new FavoriteMovieFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.loadFavorite();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_favorite, container, false);
        ButterKnife.bind(this, view);
        presenter = new MovieFavoritePresenter();
        presenter.setView(this);
        context = getContext();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(MovieDetail item);
    }


    @Override
    public void onDataFound(List<MovieDetail> movies) {
        noFavorite.setVisibility(View.GONE);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        recyclerView.setAdapter(new MovieFavoriteAdapter(movies, mListener, context));
    }

    @Override
    public void onNoFavorite() {
        noFavorite.setVisibility(View.VISIBLE);
    }

}
