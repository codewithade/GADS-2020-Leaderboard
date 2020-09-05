package com.smatworld.gads2020leaderboard.remote.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubmissionBuilder {
    private static final String BASE_URL = "https://docs.google.com/forms/d/e/";

    // create Logger
    private static final HttpLoggingInterceptor logger = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    // create OkHttpClient
    private static final OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder().addInterceptor(logger);

    private static final Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient.build());

    private static Retrofit sRetrofit = builder.build();

    public static <S> S buildService(Class<S> serviceType) {
        return sRetrofit.create(serviceType);
    }
}
