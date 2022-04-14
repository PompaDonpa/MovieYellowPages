package com.example.movieyellowpages.Listenres;

import com.example.movieyellowpages.models.SearchApiResponse;

public interface OnSearchApiListener {
    void onResponse(SearchApiResponse response);
    void onError(String message);

}
