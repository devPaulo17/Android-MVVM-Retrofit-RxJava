package com.devPaul.pruebamerqueo.viewModel;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.view.View;

import com.devPaul.pruebamerqueo.R;
import com.devPaul.pruebamerqueo.app.AppController;
import com.devPaul.pruebamerqueo.model.Movie;
import com.devPaul.pruebamerqueo.model.MoviesResponse;
import com.devPaul.pruebamerqueo.network.MoviesService;


import java.util.ArrayList;
import java.util.List;
import java.util.Observable;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;


import static com.devPaul.pruebamerqueo.utils.Constant.RANDOM_MOVIES_URL;

/**
 * Created by devPaul on 18/9/18.
 */

public class MovieViewModel extends Observable {

    public ObservableInt progressBar;
    public ObservableInt movieRecycler;
    public ObservableInt movieLabel;
    public ObservableField<String> messageLabel;

    private List<Movie> movieList;
    private Context context;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public MovieViewModel(@NonNull Context context) {
        this.context = context;
        this.movieList = new ArrayList<>();
        progressBar = new ObservableInt(View.GONE);
        movieRecycler = new ObservableInt(View.GONE);
        movieLabel = new ObservableInt(View.VISIBLE);
        messageLabel = new ObservableField<>(context.getString(R.string.default_message_loading_movies));
    }

    public void onClickFabToLoad(View view) {
        initializeViews();
        fetchMoviesList();
    }

    //It is "public" to show an example of test
    public void initializeViews() {
        movieLabel.set(View.GONE);
        movieRecycler.set(View.GONE);
        progressBar.set(View.VISIBLE);
    }

    private void fetchMoviesList() {

        AppController appController = AppController.create(context);
        MoviesService moviesService = appController.getMoviesService();

        Disposable disposable = moviesService.fetchMovies(RANDOM_MOVIES_URL)
                .subscribeOn(appController.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MoviesResponse>() {
                    @Override public void accept(MoviesResponse moviesResponse) throws Exception {
                        updateMovieDataList(moviesResponse.getPeopleList());
                        progressBar.set(View.GONE);
                        movieLabel.set(View.GONE);
                        movieRecycler.set(View.VISIBLE);
                    }
                }, new Consumer<Throwable>() {
                    @Override public void accept(Throwable throwable) throws Exception {
                        messageLabel.set(context.getString(R.string.error_message_loading_movies));
                        progressBar.set(View.GONE);
                        movieLabel.set(View.VISIBLE);
                        movieRecycler.set(View.GONE);
                    }
                });

        compositeDisposable.add(disposable);
    }

    private void updateMovieDataList(List<Movie> peoples) {
        movieList.addAll(peoples);
        setChanged();
        notifyObservers();
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    private void unSubscribeFromObservable() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    public void reset() {
        unSubscribeFromObservable();
        compositeDisposable = null;
        context = null;
    }
}

