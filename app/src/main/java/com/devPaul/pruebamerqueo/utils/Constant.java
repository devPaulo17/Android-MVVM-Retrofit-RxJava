package com.devPaul.pruebamerqueo.utils;

import com.devPaul.pruebamerqueo.BuildConfig;

/**
 * Created by devPaul on 18/9/18.
 */

public interface Constant {

    public final  String BASE_URL = "https://api.themoviedb.org/3/movie/";
    public final  String RANDOM_MOVIES_URL = "https://api.themoviedb.org/3/movie/popular?api_key="+BuildConfig.API_KEY_MOVIES+"&page=1";
    public final  String ENDPOINT_IMAGE = "https://image.tmdb.org/t/p/w500";

}
