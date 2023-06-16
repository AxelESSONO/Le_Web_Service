package com.axel.lewebservice;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TVShowService {

    @GET("most-popular")
    Call<TVShowRoot> getTVShowList(@Query("page") int page);

}
