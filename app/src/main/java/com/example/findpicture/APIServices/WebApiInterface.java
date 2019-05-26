package com.example.findpicture.APIServices;

import com.example.findpicture.Models.PixabayImageList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebApiInterface {

    public interface PixabayApi {

        @GET("/api/")
        Call<PixabayImageList> getImageResults(@Query("key") String key,
                                               @Query("q") String query,
                                               @Query("page") int page,
                                               @Query("per_page") int perPage);
    }
}
