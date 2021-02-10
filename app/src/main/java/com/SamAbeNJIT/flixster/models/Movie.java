package com.SamAbeNJIT.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;


@Parcel
public class Movie {

    int movieId;
    String posterPath;
    String title;
    String overview;
    double rating;
    //empty constructor need by Parcel library
    public Movie(){

    }

    public Movie(JSONObject jsonObject) throws JSONException {
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        rating = jsonObject.getDouble("vote_average");
        movieId = jsonObject.getInt("id");
    }

    public static List<Movie> fromJsonArray(JSONArray movieJSONArray){
        List<Movie> movies = new ArrayList<>();
        for(int i=0;i<movieJSONArray.length();i++){
            try {
                movies.add(new Movie(movieJSONArray.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return movies;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public float getRating() { return (float) rating; }

    public int getId(){ return movieId; }
}
