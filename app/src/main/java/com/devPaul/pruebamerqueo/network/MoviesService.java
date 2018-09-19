package com.devPaul.pruebamerqueo.network;


import com.devPaul.pruebamerqueo.model.MoviesResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by devPaul on 18/9/18.
 */

public interface MoviesService {

    @GET
    Observable<MoviesResponse> fetchMovies(@Url String url);
}
