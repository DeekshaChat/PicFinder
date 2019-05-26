package com.example.findpicture.APIServices;

import android.content.Context;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PixabayWebService {

    public static WebApiInterface.PixabayApi createPixabayService(Context context) {

     /*   long cacheSize = (5 * 1024 * 1024).toLong();
        val myCache = Cache(context.cacheDir, cacheSize);

        val okHttpClient = OkHttpClient.Builder()
                .cache(myCache)
                .addInterceptor { chain ->
                var request = chain.request();
            request = if (hasNetwork(context)!!)
            request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
                    else
            request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build()
            chain.proceed(request);
        }
                .build();
*/

        int cacheSize = 50 * 1024 * 1024; // 50 MB
        Cache cache = new Cache(context.getCacheDir(), cacheSize);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .build();

        Retrofit.Builder builder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .baseUrl("https://pixabay.com/");

        return builder.build().create(WebApiInterface.PixabayApi.class);
    }
}
