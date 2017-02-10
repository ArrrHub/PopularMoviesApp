package com.example.dat.popularmoviesapp.Utilities;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
/**
 * Created by dat on 2017-02-10.
 */

public final class NetworkUtils {
    //http://api.themoviedb.org/3/movie/popular?api_key
    public static final String BASE_MOVIEDB_URL = "http://api.themoviedb.org/3/movie/";


    public static URL buildUrl(String requestType) {
        String APIkeyV3 = "f39d4c2d598f29ac20b5b38086ed90c1";

        Uri builtUri = Uri.parse(BASE_MOVIEDB_URL).buildUpon()
                .appendPath(requestType)
                .appendQueryParameter("api_key", APIkeyV3)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Log.v(NetworkUtils.class.getSimpleName(), "Built URI " + url);

        return url;
    }

    public static String getResponse(URL url) throws IOException
    {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }

}
