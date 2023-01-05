package com.example.tadaapp.Retrofits;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServices {

    public static Retrofit getRetrofit() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor ();
        httpLoggingInterceptor.setLevel (HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder ()
                .addInterceptor (httpLoggingInterceptor).build ();

        Retrofit retrofit = new Retrofit.Builder ()
                .baseUrl ("https://tada.progressiveaidata.in/api/")
                .addConverterFactory (GsonConverterFactory.create ())
                .client (okHttpClient)
                .build ();

        return retrofit;
    }
}
