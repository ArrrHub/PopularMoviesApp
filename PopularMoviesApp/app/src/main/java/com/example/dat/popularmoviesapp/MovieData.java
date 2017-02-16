package com.example.dat.popularmoviesapp;

/**
 * Created by dat on 2017-02-08.
 */

public class MovieData {

    public String imagePath;
    public String largeImagePath;
    public String Title;
    public String ReleaseDate;
    public String VoteAverage;
    public String Synopsis;

    public MovieData(String path, String largeImagePath, String Title, String ReleaseDate, String VoteAverage, String Synopsis)
    {
        imagePath = path;
        this.largeImagePath = largeImagePath;
        this.Title = Title;
        this.ReleaseDate = ReleaseDate;
        this.VoteAverage = VoteAverage;
        this.Synopsis = Synopsis;
    }
}