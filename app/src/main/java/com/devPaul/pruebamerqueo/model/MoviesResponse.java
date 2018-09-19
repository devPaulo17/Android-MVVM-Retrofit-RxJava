package com.devPaul.pruebamerqueo.model;

import com.devPaul.pruebamerqueo.model.Movie;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by devPaul on 18/9/18.
 */

public class MoviesResponse {

    @SerializedName("results") private List<Movie> movieList;

    public List<Movie> getPeopleList () { return movieList;}

    public void setPeopleList(List<Movie> mmovieList) { this.movieList = mmovieList ;}

}
