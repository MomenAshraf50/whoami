package com.example.whoami.api;

import com.example.whoami.Answers;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiPost {
    @POST("Q_A/api/results")
    public Call<Integer>  storePost(@Body List<String> answers);
}
