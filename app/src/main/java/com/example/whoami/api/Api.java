package com.example.whoami.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("Q_A/api/question-list")
    Call<QuestionsResponse> getQuestions();

}
