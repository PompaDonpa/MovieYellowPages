package com.example.movieyellowpages.models;

import java.util.List;

public class SearchApiResponse {
    List<SearchArrayObject> genres = null;
    List<SearchArrayObject> production_companies = null;
    List<SearchArrayObject> production_countries = null;
    List<SearchArrayObject> spoken_languages = null;

    public List<SearchArrayObject> getGenres() {
        return genres;
    }

    public void setGenres(List<SearchArrayObject> genres) {
        this.genres = genres;
    }

    public List<SearchArrayObject> getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(List<SearchArrayObject> production_companies) {
        this.production_companies = production_companies;
    }

    public List<SearchArrayObject> getProduction_countries() {
        return production_countries;
    }

    public void setProduction_countries(List<SearchArrayObject> production_countries) {
        this.production_countries = production_countries;
    }

    public List<SearchArrayObject> getSpoken_languages() {
        return spoken_languages;
    }

    public void setSpoken_languages(List<SearchArrayObject> spoken_languages) {
        this.spoken_languages = spoken_languages;
    }
}
