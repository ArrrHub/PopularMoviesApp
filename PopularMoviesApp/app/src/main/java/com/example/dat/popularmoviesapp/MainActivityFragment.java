package com.example.dat.popularmoviesapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.dat.popularmoviesapp.MovieDataAdapter;
import com.example.dat.popularmoviesapp.Utilities.JsonUtils;
import com.example.dat.popularmoviesapp.Utilities.NetworkUtils;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A fragment containing the list view of Android versions.
 */
public class MainActivityFragment extends Fragment {

    private MovieDataAdapter movieDataAdapter;

    public MovieData[] MovieDataArray =
    {
        new MovieData("http://image.tmdb.org/t/p/w185//WLQN5aiQG8wc9SeKwixW7pAR8K.jpg", "http://image.tmdb.org/t/p/w500//WLQN5aiQG8wc9SeKwixW7pAR8K.jpg", "a", "b", "c", "d"),
            new MovieData("http://image.tmdb.org/t/p/w185//WLQN5aiQG8wc9SeKwixW7pAR8K.jpg", "http://image.tmdb.org/t/p/w500//WLQN5aiQG8wc9SeKwixW7pAR8K.jpg", "a", "b", "c", "d"),
            new MovieData("http://image.tmdb.org/t/p/w185//WLQN5aiQG8wc9SeKwixW7pAR8K.jpg", "http://image.tmdb.org/t/p/w500//WLQN5aiQG8wc9SeKwixW7pAR8K.jpg", "a", "b", "c", "d"),
            new MovieData("http://image.tmdb.org/t/p/w185//WLQN5aiQG8wc9SeKwixW7pAR8K.jpg", "http://image.tmdb.org/t/p/w500//WLQN5aiQG8wc9SeKwixW7pAR8K.jpg", "a", "b", "c", "d"),
            new MovieData("http://image.tmdb.org/t/p/w185//WLQN5aiQG8wc9SeKwixW7pAR8K.jpg", "http://image.tmdb.org/t/p/w500//WLQN5aiQG8wc9SeKwixW7pAR8K.jpg", "a", "b", "c", "d"),
            new MovieData("http://image.tmdb.org/t/p/w185//WLQN5aiQG8wc9SeKwixW7pAR8K.jpg", "http://image.tmdb.org/t/p/w500//WLQN5aiQG8wc9SeKwixW7pAR8K.jpg", "a", "b", "c", "d"),
            new MovieData("http://image.tmdb.org/t/p/w185//WLQN5aiQG8wc9SeKwixW7pAR8K.jpg", "http://image.tmdb.org/t/p/w500//WLQN5aiQG8wc9SeKwixW7pAR8K.jpg", "a", "b", "c", "d"),
            new MovieData("http://image.tmdb.org/t/p/w185//WLQN5aiQG8wc9SeKwixW7pAR8K.jpg", "http://image.tmdb.org/t/p/w500//WLQN5aiQG8wc9SeKwixW7pAR8K.jpg", "a", "b", "c", "d"),
            new MovieData("http://image.tmdb.org/t/p/w185//WLQN5aiQG8wc9SeKwixW7pAR8K.jpg", "http://image.tmdb.org/t/p/w500//WLQN5aiQG8wc9SeKwixW7pAR8K.jpg", "a", "b", "c", "d"),
            new MovieData("http://image.tmdb.org/t/p/w185//WLQN5aiQG8wc9SeKwixW7pAR8K.jpg", "http://image.tmdb.org/t/p/w500//WLQN5aiQG8wc9SeKwixW7pAR8K.jpg", "a", "b", "c", "d")
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
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @SuppressLint("NewApi")
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long id)
            {

                MovieData movieData =  (MovieData) arg0.getAdapter().getItem(position);

                Class destinationActivity = DetailsScreen.class;
                Intent detailActivityIntent = new Intent(getActivity(), destinationActivity);

                String[] combinedMovieDetails = new String[5];
                combinedMovieDetails[0] = movieData.largeImagePath;
                combinedMovieDetails[1] = movieData.Title;
                combinedMovieDetails[2] = "Release date: " + movieData.ReleaseDate;
                combinedMovieDetails[3] = "Score Average: " + movieData.VoteAverage;
                combinedMovieDetails[4] = movieData.Synopsis;

                detailActivityIntent.putExtra(Intent.EXTRA_TEXT, combinedMovieDetails);

                startActivity(detailActivityIntent);

            }
        });
        gridView.setAdapter(movieDataAdapter);

        return rootView;
    }

}