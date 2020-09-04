package com.smatworld.gads2020leaderboard.remote.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubmissionBuilder {
    private static final String BASE_URL = "https://docs.google.com/forms/d/e/";
    private static final Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit sRetrofit = builder.build();

    public static <S> S buildService(Class<S> serviceType) {
        return sRetrofit.create(serviceType);
    }
}
