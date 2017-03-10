package com.example.dat.popularmoviesapp.Utilities;

import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;

import com.example.dat.popularmoviesapp.R;

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

    public static URL buildUrl(String requestType) {
        //"http://api.themoviedb.org/3/movie/"
        Uri builtUri = Uri.parse(Resources.getSystem().getString(R.string.baseMovieDbUrl)).buildUpon()
                .appendPath(requestType)
                .appendQueryParameter(Resources.getSystem().getString(R.string.apiKeyTag),
                        Resources.getSystem().getString(R.string.APIkeyV3))
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
