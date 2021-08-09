package com.example.retroapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HeroAPI {

    @GET("all.json")
    Call<List<Hero>> getHeroes();

}
