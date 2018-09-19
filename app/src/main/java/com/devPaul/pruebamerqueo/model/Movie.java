package com.devPaul.pruebamerqueo.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by devPaul on 18/9/18.
 */

public class Movie implements Serializable {

    @SerializedName("title") public String title;

    @SerializedName("vote_average") public double vote_average;

    @SerializedName("original_title") public String  original_title;

    @SerializedName("id") public int id;

    @SerializedName("vote_count") public int vote_count;

    @SerializedName("overview") public String overview;

    @SerializedName("original_language") public String original_language;

    @SerializedName("release_date") public String release_date;

    @SerializedName("poster_path") public String poster_path;

    @SerializedName("backdrop_path") public String backdrop_path;


}
