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

    private static JSONObject JSONobj = null;
}