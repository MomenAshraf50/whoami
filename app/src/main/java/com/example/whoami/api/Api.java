package com.example.whoami.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    @GET("Q_A/api/question-list")
    Call<QuestionsResponse> getQuestions();

    @POST("Q_A/api/results")
    public Call<Integer>  storePost(@Body List<String> answers);

}
