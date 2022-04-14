package com.example.movieyellowpages;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.movieyellowpages.Listenres.OnSearchApiListener;
import com.example.movieyellowpages.models.SearchApiResponse;

import java.util.Properties;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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

    public void searchMovies(OnSearchApiListener Listener, String movieName) {
        getMovies getMovies = retrofit.create(RequestManager.getMovies.class);
        Call<SearchApiResponse> call = getMovies.callMovies(movieName);

        call.enqueue(new Callback<SearchApiResponse>() {
            @Override
            public void onResponse(@NonNull Call<SearchApiResponse> call, @NonNull Response<SearchApiResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(context, "Couldn't fetch Data", Toast.LENGTH_SHORT).show();
                    return;
                }
                Listener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<SearchApiResponse> call, Throwable t) {
                Listener.onError(t.getMessage());
            }
        });
;
    }


    public interface getMovies {
        @Headers({
                "Accept: application/json",
                "Content-Type: application/json;charset=utf-8"
        })
        @GET("movie/{movie_id}")
        Call<SearchApiResponse> callMovies(
          @Path("movie_id") String movie_id
        );
    }
}

