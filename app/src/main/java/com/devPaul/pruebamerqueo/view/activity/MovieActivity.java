package com.devPaul.pruebamerqueo.view.activity;

import android.arch.core.BuildConfig;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.devPaul.pruebamerqueo.R;
import com.devPaul.pruebamerqueo.databinding.ActivityMoviesBinding;
import com.devPaul.pruebamerqueo.view.adapter.MovieAdapter;
import com.devPaul.pruebamerqueo.viewModel.MovieViewModel;

import java.util.Observable;
import java.util.Observer;

public class MovieActivity extends AppCompatActivity implements Observer {

    private ActivityMoviesBinding movieActivityBinding;
    private MovieViewModel movieViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        setSupportActionBar(movieActivityBinding.toolbar);
        setUpListOfMoviesView(movieActivityBinding.listMovie);
        setUpObserver(movieViewModel);
    }

    private void initDataBinding() {
        movieActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_movies);
        movieViewModel = new MovieViewModel(this);
        movieActivityBinding.setMovieViewModel(movieViewModel);
    }

    // set up the list of Movie with recycler view
    private void setUpListOfMoviesView(RecyclerView listMovie) {

        MovieAdapter movieAdapter = new MovieAdapter();
        listMovie.setAdapter(movieAdapter);
        listMovie.setLayoutManager(new LinearLayoutManager(this));
    }

    public void setUpObserver(Observable observable) {
        observable.addObserver(this);
    }


    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof MovieViewModel) {
            MovieAdapter movieAdapter = (MovieAdapter) movieActivityBinding.listMovie.getAdapter();
            MovieViewModel MovieViewModel = (MovieViewModel) o;
            movieAdapter.setmovieList(MovieViewModel.getMovieList());
        }
    }


    @Override protected void onDestroy() {
        super.onDestroy();
        movieViewModel.reset();
    }


}
