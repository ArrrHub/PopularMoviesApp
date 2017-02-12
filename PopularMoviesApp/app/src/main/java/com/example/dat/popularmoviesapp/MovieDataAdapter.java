package com.example.dat.popularmoviesapp;

/**
 * Created by dat on 2017-02-08.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieDataAdapter extends ArrayAdapter<MovieData> {
    private static final String LOG_TAG = MovieDataAdapter.class.getSimpleName();
    private Activity contextHolder;

    public MovieDataAdapter(Activity context, ArrayList<MovieData> MovieDataList) {

        super(context, 0, MovieDataList);
        contextHolder = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MovieData movieData = getItem(position);

        if(convertView==null)
        {
            convertView = ((LayoutInflater) contextHolder.getSystemService(contextHolder.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.movie_item, null);
        }

        ImageView iconView = (ImageView) convertView.findViewById(R.id.movie_image);

        if(!movieData.imagePath.isEmpty() && (iconView!=null))
            Picasso.with(contextHolder).load(movieData.imagePath).into(iconView);



        return convertView;
    }
}