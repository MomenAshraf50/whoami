package com.example.whoami.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;
    public static Api getService(){
        if (retrofit==null){
            retrofit =new Retrofit.Builder()
                    .baseUrl("https://youssefmm.pythonanywhere.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(Api.class);
    }


}
