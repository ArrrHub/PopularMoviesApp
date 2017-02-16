package com.example.dat.popularmoviesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_screen);

        Intent startingIntent = getIntent();

        if(startingIntent.hasExtra(Intent.EXTRA_TEXT))
        {
//            imagePath;
//            Title;
//            ReleaseDate;
//            VoteAverage;
//            Synopsis;

            String extraStrings[] = startingIntent.getStringArrayExtra(Intent.EXTRA_TEXT);

            ImageView mainImage = (ImageView) findViewById(R.id.detailsViewImage);

            if(!extraStrings[0].isEmpty() && (mainImage!=null))
                Picasso.with(this).load(extraStrings[0]).into(mainImage);

            ((TextView) findViewById(R.id.detailsViewTitle)).setText(extraStrings[1]);
            ((TextView) findViewById(R.id.detailsViewReleaseDate)).setText(extraStrings[2]);
            ((TextView) findViewById(R.id.detailsViewVoteAverage)).setText(extraStrings[3]);
            ((TextView) findViewById(R.id.detailsViewSynopsis)).setText(extraStrings[4]);

        }


    }
}
