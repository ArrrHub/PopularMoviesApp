package com.example.dat.popularmoviesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class DetailsScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_screen);

        Intent startingIntent = getIntent();

        if(startingIntent.hasExtra(Intent.EXTRA_TEXT))
        {
            String imagePath = startingIntent.getStringExtra(Intent.EXTRA_TEXT);
            ImageView mainImage = (ImageView) findViewById(R.id.detailsViewImage);

            if(!imagePath.isEmpty() && (mainImage!=null))
                Picasso.with(this).load(imagePath).into(mainImage);


        }


    }
}
