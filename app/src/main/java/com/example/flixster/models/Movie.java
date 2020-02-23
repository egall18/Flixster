package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;


@Parcel
public class Movie {

    int movieId;
    String background_path;
    String poster_path;
    String title;
    String overview;
    double rating;


    //Empty constructor needed by the Parceler library
    public Movie(){ }

    public Movie(JSONObject jsonObject) throws JSONException
    {
        background_path = jsonObject.getString("backdrop_path");
        poster_path = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        rating = jsonObject.getDouble("vote_average");
        movieId = jsonObject.getInt("id");
    }


    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException
    {
        List<Movie> movies = new ArrayList<>();
        for(int i =0; i < movieJsonArray.length(); i++)
        {
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getBackgroundPath()
    {
        return String.format("https://image.tmdb.org/t/p/w342/%s",background_path);
    }


    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",poster_path);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public double getRating() { return rating; }

    public int getMovieId(){ return movieId; };
}
