package com.example.whoami.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;
    public static Api getService(){
        if (retrofit==null){
            retrofit =new Retrofit.Builder()
                    .baseUrl("https://d265-156-204-222-111.ngrok.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(Api.class);
    }
}
