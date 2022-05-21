package com.example.whoami.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;
    public static Api getService(){
        if (retrofit==null){
            retrofit =new Retrofit.Builder()
                    .baseUrl("https://49ab-197-46-45-161.ngrok.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(Api.class);
    }


}
