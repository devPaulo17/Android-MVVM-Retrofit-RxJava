package com.devPaul.pruebamerqueo.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.devPaul.pruebamerqueo.utils.Constant.BASE_URL;


/**
 * Created by devPaul on 18/9/18.
 */

public class ApiFactory {

    public static MoviesService create() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(MoviesService.class);
    }

}
