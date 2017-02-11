package com.example.dat.popularmoviesapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.GridView;

import com.example.dat.popularmoviesapp.MovieDataAdapter;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A fragment containing the list view of Android versions.
 */
public class MainActivityFragment extends Fragment {

    private MovieDataAdapter movieDataAdapter;

    public MovieData[] MovieDataArray = {
       new MovieData("http://image.tmdb.org/t/p/w185//WLQN5aiQG8wc9SeKwixW7pAR8K.jpg"),
            new MovieData("http://image.tmdb.org/t/p/w185//WLQN5aiQG8wc9SeKwixW7pAR8K.jpg"),
            new MovieData("http://image.tmdb.org/t/p/w185//WLQN5aiQG8wc9SeKwixW7pAR8K.jpg"),
            new MovieData("http://image.tmdb.org/t/p/w185//WLQN5aiQG8wc9SeKwixW7pAR8K.jpg"),
            new MovieData("http://image.tmdb.org/t/p/w185//WLQN5aiQG8wc9SeKwixW7pAR8K.jpg"),
            new MovieData("http://image.tmdb.org/t/p/w185//WLQN5aiQG8wc9SeKwixW7pAR8K.jpg"),
            new MovieData("http://image.tmdb.org/t/p/w185//WLQN5aiQG8wc9SeKwixW7pAR8K.jpg"),
            new MovieData("http://image.tmdb.org/t/p/w185//WLQN5aiQG8wc9SeKwixW7pAR8K.jpg"),
            new MovieData("http://image.tmdb.org/t/p/w185//WLQN5aiQG8wc9SeKwixW7pAR8K.jpg"),
            new MovieData("http://image.tmdb.org/t/p/w185//WLQN5aiQG8wc9SeKwixW7pAR8K.jpg")
    };

    public MainActivityFragment() {
    }

    public MovieDataAdapter getMovieDataAdapter()
    {
        return movieDataAdapter;
    }

    public MovieData[] getMovieDataArray()
    {
        return MovieDataArray;
    }

    public void setMovieDataArray(MovieData[] md)
    {
        MovieDataArray = md;
    }

    public void clearMovieData()
    {
        MovieDataArray = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        movieDataAdapter = new MovieDataAdapter(getActivity(), new ArrayList<MovieData>(Arrays.asList(MovieDataArray)));

        // Get a reference to the ListView, and attach this adapter to it.
        GridView gridView = (GridView) rootView.findViewById(R.id.flavors_grid);
        gridView.setAdapter(movieDataAdapter);

        return rootView;
    }

    public void refreshView()
    {
        movieDataAdapter = new MovieDataAdapter(getActivity(), new ArrayList<MovieData>(Arrays.asList(MovieDataArray)));

        // Get a reference to the ListView, and attach this adapter to it.
//        GridView gridView = (GridView) findViewById(R.id.flavors_grid);
//        gridView.setAdapter(movieDataAdapter);

    }
}