package com.devPaul.pruebamerqueo.app;

import android.app.Application;
import android.content.Context;


import com.devPaul.pruebamerqueo.network.ApiFactory;
import com.devPaul.pruebamerqueo.network.MoviesService;


import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by devPaul on 18/9/18.
 */

public class AppController extends Application {

    private MoviesService moviesService;
    private Scheduler scheduler;

    private static AppController get(Context context) {
        return (AppController) context.getApplicationContext();
    }

    public static AppController create(Context context) {
        return AppController.get(context);
    }

    public MoviesService getMoviesService() {
        if (moviesService == null) {
            moviesService = ApiFactory.create();
        }

        return moviesService;
    }

    public Scheduler subscribeScheduler() {
        if (scheduler == null) {
            scheduler = Schedulers.io();
        }

        return scheduler;
    }


}
