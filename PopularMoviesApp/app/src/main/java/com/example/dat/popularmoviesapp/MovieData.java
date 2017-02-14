package com.example.dat.popularmoviesapp;

/**
 * Created by dat on 2017-02-08.
 */

public class MovieData {

    public String imagePath; // drawable reference id
    private String Title;
    private String ReleaseDate;
    private String VoteAverage;
    private String Synopsis;

    public MovieData(String path, String Title, String ReleaseDate, String VoteAverage, String Synopsis)
    {
        imagePath = path;
        this.Title = Title;
        this.ReleaseDate = ReleaseDate;
        this.VoteAverage = VoteAverage;
        this.Synopsis = Synopsis;
    }
}