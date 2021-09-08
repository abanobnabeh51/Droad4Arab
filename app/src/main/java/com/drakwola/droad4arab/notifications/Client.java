package com.drakwola.droad4arab.notifications;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
   private static Retrofit retrofi =null;
    public static Retrofit getRetrofi(String url){
        if (retrofi == null){
            retrofi = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofi;
    }

}
