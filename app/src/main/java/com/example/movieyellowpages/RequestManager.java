package com.example.movieyellowpages;

import android.content.Context;

import com.example.movieyellowpages.models.SearchApiResponse;

import java.util.Properties;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public class RequestManager {
    Context context;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/movie/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static final String API_RAT = System.getenv("API_RAT");
    public static final String API_KEY = System.getenv("API_KEY");

    public RequestManager(Context context) {
        this.context = context;
    }

    String template = "Authorization: Bearer %s";
    String result = String.format(template, API_RAT);

    public interface getMovies {
        @Headers({
                result,
                --header 'Content-Type: application/json;charset=utf-8'
                "Accept: application/json"
        })
        @GET("movie/{movie_id}")
        Call<SearchApiResponse> callMovies(
          @Path("movie_id") Integer movie_id
        );
    }
}

