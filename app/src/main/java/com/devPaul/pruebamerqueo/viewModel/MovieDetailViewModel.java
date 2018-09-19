package com.devPaul.pruebamerqueo.viewModel;


import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.devPaul.pruebamerqueo.model.Movie;

import java.util.Observable;

import static com.devPaul.pruebamerqueo.utils.Constant.ENDPOINT_IMAGE;

/**
 * Created by devPaul on 18/9/18.
 */
/*
** This Class as ViewModel to exposes streams of data relevant to the View (MovieDetailActivity).
 */

public class MovieDetailViewModel extends Observable {

    private Movie movie;

    public MovieDetailViewModel(Movie movie) {this.movie = movie;}



    public String getTitle(){return movie.title;}

    public String getVote(){
        return "# Votos: "+movie.vote_count;
    }


    public String getOverview() { return movie.overview; }

    public String getLanguage() { return "Idioma: " + movie.original_language; }


    public String  getOrignalTitle() { return "Título Original: "+movie.original_title; }

    public String getProfileThumb() {
        String poster = ENDPOINT_IMAGE+""+movie.backdrop_path;
        return poster;
    }


    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String imageUrl){
        Glide.with(view.getContext()).load(imageUrl).into(view);
    }


}
