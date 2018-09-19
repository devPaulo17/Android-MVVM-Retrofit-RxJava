package com.devPaul.pruebamerqueo.viewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.devPaul.pruebamerqueo.model.Movie;
import com.devPaul.pruebamerqueo.view.activity.MovieDetailActivity;

import static com.devPaul.pruebamerqueo.utils.Constant.ENDPOINT_IMAGE;

/**
 * Created by devPaul on 18/9/18.
 */

public class ItemMovieViewModel extends BaseObservable {

    private Movie movie;
    private Context context;

    public ItemMovieViewModel(Movie movie, Context context){
        this.movie = movie;
        this.context = context;
    }

    public String getProfileThumb() {

        String poster = ENDPOINT_IMAGE+""+movie.poster_path;
        return poster;
    }

    // Loading Image using Glide Library.
    @BindingAdapter("imageUrl") public static void setImageUrl(ImageView imageView, String url){
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

    public String getReleaseDate() { return movie.release_date; }

    public String getTitle() { return movie.title; }

    public String getScore(){return movie.vote_average+"/10";}


    public void onItemClick(View v){
        context.startActivity(MovieDetailActivity.fillDetail(v.getContext(), movie));
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
        notifyChange();
    }
}
