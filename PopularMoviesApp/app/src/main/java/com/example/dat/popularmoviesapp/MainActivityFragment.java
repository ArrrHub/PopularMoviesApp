package com.example.dat.popularmoviesapp;

import android.annotation.SuppressLint;
import android.content.Intent;
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
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @SuppressLint("NewApi")
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long id)
            {

                MovieData movieData =  (MovieData) arg0.getAdapter().getItem(position);

                Class destinationActivity = DetailsScreen.class;
                Intent detailActivityIntent = new Intent(getActivity(), destinationActivity);

                detailActivityIntent.putExtra(Intent.EXTRA_TEXT, movieData.imagePath);

                startActivity(detailActivityIntent);
                //Toast.makeText(getActivity(), movieData.imagePath , Toast.LENGTH_SHORT).show();
            }
        });
        gridView.setAdapter(movieDataAdapter);

        return rootView;
    }
}