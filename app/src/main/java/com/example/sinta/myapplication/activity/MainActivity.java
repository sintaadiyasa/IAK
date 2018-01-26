package com.example.sinta.myapplication.activity;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.sinta.myapplication.fragment.FavoriteMovieFragment;
import com.example.sinta.myapplication.fragment.MovieFragment;
import com.example.sinta.myapplication.R;


import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.sinta.myapplication.utility.Constant.FragmentChooser.FAVORITE;
import static com.example.sinta.myapplication.utility.Constant.FragmentChooser.NOW_PLAYING;
import static com.example.sinta.myapplication.utility.Constant.FragmentChooser.POPULAR;
import static com.example.sinta.myapplication.utility.Constant.FragmentChooser.TOP_RATED;
import static com.example.sinta.myapplication.utility.Constant.FragmentChooser.UPCOMING;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        fragment = MovieFragment.newInstance(NOW_PLAYING);
        toolbar.setTitle(NOW_PLAYING);
        getSupportFragmentManager().beginTransaction().add(R.id.frame_layout, fragment).commit();
    }

    private void setFragment(Fragment fragment, String jenis) {
        toolbar.setTitle(jenis);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
    }

    private void initView() {
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.action_now_playing) {
            fragment = MovieFragment.newInstance(NOW_PLAYING);
            setFragment(fragment, NOW_PLAYING);
        } else if (id == R.id.action_popular) {
            fragment = MovieFragment.newInstance(POPULAR);
            setFragment(fragment, POPULAR);
        } else if (id == R.id.action_up_coming) {
            fragment = MovieFragment.newInstance(UPCOMING);
            setFragment(fragment, UPCOMING);
        } else if (id == R.id.action_top_rated) {
            fragment = MovieFragment.newInstance(TOP_RATED);
            setFragment(fragment, TOP_RATED);
        } else if (id == R.id.action_favorite) {
            fragment = MovieFragment.newInstance(FAVORITE);
            setFragment(fragment, FAVORITE);
        } else if (id == R.id.action_exit) {
            System.exit(0);
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
