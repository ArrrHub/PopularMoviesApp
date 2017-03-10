package com.example.dat.popularmoviesapp;

import android.app.Fragment;
import android.graphics.Movie;
import android.os.AsyncTask;
import android.os.NetworkOnMainThreadException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.dat.popularmoviesapp.Utilities.JsonUtils;
import com.example.dat.popularmoviesapp.Utilities.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        new FetchTvDataTask().execute("popular");
        setContentView(R.layout.activity_main);
    }


    public class FetchTvDataTask extends AsyncTask<String, Void, JSONArray>
    {

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }

        @Override
        protected JSONArray doInBackground(String... params)
        {
            try
            {
                String response = NetworkUtils.getResponse(NetworkUtils.buildUrl(params[0]));
                JsonUtils.initJsonObject(response);
                //List<String> posterAddresses = JsonUtils.getPopularMoviePostersAddress();
                //List<String> movieData = JsonUtils.getPopularMovieList();

                return JsonUtils.getPopularMovieArray();
                //return (String [])movieData.toArray(new String[movieData.size()]);
            }
            catch (IOException|JSONException e)
            {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(JSONArray movieArray)
        {
            super.onPostExecute(movieArray);

            if(movieArray != null)
            {
                MainActivityFragment mainActivityFragment = (MainActivityFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
                MovieDataAdapter adapter = mainActivityFragment.getMovieDataAdapter();

                adapter.clear();

                try {
                    for (int i = 0; i < movieArray.length(); i++) {
                        JSONObject jsonMovieData = movieArray.getJSONObject(i);
                        String imagePath = "http://image.tmdb.org/t/p/w185/" + jsonMovieData.get("poster_path");
                        String largeImagePath = "http://image.tmdb.org/t/p/w500/" + jsonMovieData.get("poster_path");

                        MovieData movieData = new MovieData(imagePath, largeImagePath, jsonMovieData.getString("title"), jsonMovieData.getString("release_date"),
                                jsonMovieData.getString("vote_average"), jsonMovieData.getString("overview"));

                        adapter.add(movieData);
                    }

                    mainActivityFragment.getMovieDataAdapter().notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        String requestType = new String();

        if (id == R.id.menuItemPopular)
        {
            requestType = "popular";

        }
        else if (id == R.id.menuItemTop_Rated)
        {
            requestType = "top_rated";

        }
        new FetchTvDataTask().execute(requestType);

        return super.onOptionsItemSelected(item);
    }
}
