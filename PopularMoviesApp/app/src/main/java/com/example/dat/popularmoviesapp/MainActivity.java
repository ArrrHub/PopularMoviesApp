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

import org.json.JSONException;

import java.io.IOException;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public class FetchTvDataTask extends AsyncTask<String, Void, String[]>
    {

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }

        @Override
        protected String[] doInBackground(String... params)
        {
            try
            {
                String response = NetworkUtils.getResponse(NetworkUtils.buildUrl(params[0]));
                JsonUtils.initJsonObject(response);
                List<String> posterAddresses = JsonUtils.getPopularMoviePostersAddress();
                return (String [])posterAddresses.toArray(new String[posterAddresses.size()]);
            }
            catch (IOException|JSONException e)
            {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String[] strings)
        {
            super.onPostExecute(strings);

            List<MovieData> movieDataInfo = new ArrayList<MovieData>();
            MainActivityFragment mainActivityFragment = (MainActivityFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
            MovieDataAdapter adapter= mainActivityFragment.getMovieDataAdapter();

            adapter.clear();

            for(String s: strings)
            {
                s = "http://image.tmdb.org/t/p/w185/" + s;
                //movieDataInfo.add(new MovieData(s));

                adapter.add(new MovieData(s));
            }

            //mainActivityFragment.setMovieDataArray((MovieData[]) movieDataInfo.toArray(new MovieData[movieDataInfo.size()]));

            mainActivityFragment.getMovieDataAdapter().notifyDataSetChanged();
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
        if (id == R.id.action_settings)
        {
            String requestType = "popular";
            new FetchTvDataTask().execute(requestType);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
