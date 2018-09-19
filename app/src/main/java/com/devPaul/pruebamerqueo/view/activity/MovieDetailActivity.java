package com.devPaul.pruebamerqueo.view.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import com.devPaul.pruebamerqueo.databinding.ActivityMovieDetailBinding;
import com.devPaul.pruebamerqueo.R;
import com.devPaul.pruebamerqueo.model.Movie;
import com.devPaul.pruebamerqueo.viewModel.MovieDetailViewModel;

public class MovieDetailActivity extends AppCompatActivity {


    private static final String EXTRA_Movie = "EXTRA_Movie";

    private ActivityMovieDetailBinding activityMovieDetailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMovieDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail);
        setSupportActionBar(activityMovieDetailBinding.toolbar);
        displayHomeAsUpEnabled();
        getExtrasFromIntent();
    }

    private void displayHomeAsUpEnabled() {

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public static Intent fillDetail(Context context, Movie Movie) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra(EXTRA_Movie, Movie);
        return intent;
    }

    private void getExtrasFromIntent(){
        Movie Movie = (Movie) getIntent().getSerializableExtra(EXTRA_Movie);
        MovieDetailViewModel MovieDetailViewModel = new MovieDetailViewModel(Movie);
        activityMovieDetailBinding.setMovieDetailViewModel(MovieDetailViewModel);
        setTitle(Movie.title + "." + Movie.original_title + " " + Movie.release_date);
    }




}
