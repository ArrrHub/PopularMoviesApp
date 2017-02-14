package com.example.dat.popularmoviesapp.Utilities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.*;
/**
 * Created by aron.boguta on 2017-02-10.
 */

public final class JsonUtils {
    public static void initJsonObject(String str)
    {
        try
        {
            JSONobj = new JSONObject(str);
        }
        catch(JSONException e)
        {
            e.printStackTrace();
        }
    };

    public static List<String> getPopularMoviePostersAddress() throws  JSONException
    {
        List<String> addresses = new ArrayList<String>();
        if(JSONobj!=null)
        {
            JSONArray arr = JSONobj.getJSONArray("results");
            for (int i = 0; i < arr.length(); i++)
            {
                JSONObject jsonMovieData = arr.getJSONObject(i);
                addresses.add(jsonMovieData.getString("poster_path"));
            }

        }
        return addresses;
    }

    public static List<String> getPopularMovieList() throws  JSONException
    {
        List<String> movies = new ArrayList<String>();
        if(JSONobj!=null)
        {
            JSONArray arr = JSONobj.getJSONArray("results");
            for (int i = 0; i < arr.length(); i++)
            {
                JSONObject jsonMovieData = arr.getJSONObject(i);
                movies.add(jsonMovieData.toString());
            }

        }
        return movies;
    }

    public static JSONArray getPopularMovieArray() throws  JSONException
    {
        return JSONobj.getJSONArray("results");
    }

    public static JSONObject getJsonMovieDataByTitle(String title) throws  JSONException
    {
        JSONObject result = null;
        if(JSONobj !=null)
        {
            JSONArray arr = JSONobj.getJSONArray("results");
            for (int i = 0; i < arr.length(); i++)
            {
                JSONObject jsonMovieData = arr.getJSONObject(i);

                if(jsonMovieData.optString ("title") == title)
                {
                    result = jsonMovieData;
                }
            }

        }
        return result;
    }

    public static Map<String, String> getParsedMovieJsonObject(JSONObject jsonMovieObject) throws  JSONException
    {
        Map<String, String> MovieInfo = new HashMap<String, String>();

        Iterator<?> keys = jsonMovieObject.keys();

        while( keys.hasNext() ) {
            String key = (String)keys.next();
            if ( jsonMovieObject.get(key) instanceof JSONObject )
            {
                MovieInfo.put(key, (String)jsonMovieObject.get(key));
            }
        }

        return MovieInfo;
    }

    private static JSONObject JSONobj = null;
}
