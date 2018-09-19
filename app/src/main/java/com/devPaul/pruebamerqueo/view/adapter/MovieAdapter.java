package com.devPaul.pruebamerqueo.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.devPaul.pruebamerqueo.R;
import com.devPaul.pruebamerqueo.databinding.ItemMovieBinding;
import com.devPaul.pruebamerqueo.databinding.ItemMovieBinding;
import com.devPaul.pruebamerqueo.model.Movie;
import com.devPaul.pruebamerqueo.viewModel.ItemMovieViewModel;

import java.util.Collections;
import java.util.List;

/**
 * Created by devPaul on 18/9/18.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieAdapterViewHolder> {

    private List<Movie> movieList;

    public MovieAdapter() {this.movieList = Collections.emptyList();}

    @Override
    public MovieAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ItemMovieBinding itemMovieBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_movie,parent, false);
        return new MovieAdapterViewHolder(itemMovieBinding);
    }

    @Override
    public void onBindViewHolder(MovieAdapterViewHolder holder, int position) {
        holder.bindMovie(movieList.get(position));

    }

    @Override
    public int getItemCount() {
        return  movieList.size();
    }

    public void setmovieList(List<Movie> movieList) {
        this.movieList = movieList;
        notifyDataSetChanged();
    }

    public static class MovieAdapterViewHolder extends RecyclerView.ViewHolder {

        ItemMovieBinding mItemMovieBinding;

        public MovieAdapterViewHolder(ItemMovieBinding itemMovieBinding) {
            super(itemMovieBinding.itemPeople);
            this.mItemMovieBinding = itemMovieBinding;
        }

        void bindMovie(Movie movie){
            if(mItemMovieBinding.getMovieViewModel() == null){
                mItemMovieBinding.setMovieViewModel(new ItemMovieViewModel(movie, itemView.getContext()));
            }else {
                mItemMovieBinding.getMovieViewModel().setMovie(movie);
            }
        }
    }
}
