package com.smatworld.gads2020leaderboard.remote.api;

import android.util.Log;

import com.smatworld.gads2020leaderboard.app.application.GADSApplication;
import com.smatworld.gads2020leaderboard.app.utils.Constant;
import com.smatworld.gads2020leaderboard.app.utils.Helper;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder {
    private static final String TAG = Constant.TAG.getConstant();
    private static final long CACHE_SIZE = 1024 * 1024 * 5;
    private static final String BASE_URL = "https://gadsapi.herokuapp.com/api/";
    private static final Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient());

    private static final Retrofit sRetrofit = builder.build();

    public static <S> S buildService(Class<S> serviceType) {
        return sRetrofit.create(serviceType);
    }

    private static Cache cache() {
        String path = GADSApplication.getApplication().getCacheDir().getPath();
        Log.i(TAG, "cache: CACHE PATH: " + path);
        return new Cache(new File(GADSApplication.getApplication().getCacheDir(), "gads_cache"), CACHE_SIZE);
    }

    private static OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                .cache(cache())
                .addInterceptor(cacheInterceptor())
                .build();
    }

    private static Interceptor cacheInterceptor() {
        return chain -> {
            Request request = chain.request();

            if (!Helper.isOnline()) { // user is offline
                Log.i(TAG, "cacheInterceptor: user is offline");
                /* https://square.github.io/okhttp/4.x/okhttp/okhttp3/-cache/#cache-optimization
                 Sometimes you’ll want to show resources if they are available immediately, but not otherwise.
                 This can be used so your application can show something while waiting for the latest data to be downloaded.
                 To restrict a request to locally-cached resources, add the only-if-cached directive:
                 To permit stale cached responses, use the max-stale directive with the maximum staleness in days:*/
                CacheControl cacheControl = new CacheControl.Builder().onlyIfCached().maxStale(365, TimeUnit.DAYS).build();
                request = request.newBuilder().cacheControl(cacheControl).build();
            } else { // user is online
                Log.i(TAG, "cacheInterceptor: user is online");
                /* In some situations, such as after a user clicks a ‘refresh’ button,
                 it may be necessary to skip the cache, and fetch data directly from the server.
                 To force a full refresh, add the no-cache directive:
                 If it is only necessary to force a cached response to be validated by the server,
                 use the more efficient max-age=0 directive instead:*/
                CacheControl cacheControl = new CacheControl.Builder().maxAge(0, TimeUnit.SECONDS).build();
                request = request.newBuilder().cacheControl(cacheControl).build();
            }
            return chain.proceed(request);
        };
    }

}
