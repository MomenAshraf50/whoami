package com.example.whoami.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;
    public static Api getService(){
        if (retrofit==null){
            retrofit =new Retrofit.Builder()
                    .baseUrl("https://8805-156-204-6-15.ngrok.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(Api.class);
    }


}
