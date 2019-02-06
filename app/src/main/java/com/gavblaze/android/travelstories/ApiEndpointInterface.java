package com.gavblaze.android.travelstories;

import com.gavblaze.android.travelstories.models.Feed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiEndpointInterface {

    @GET("everything")
    Call<Feed> getTravelStories(@Query("q") String queryParamater,
                                @Query("apiKey") String apiKey,
                                @Query("pageSize") int pageSize,
                                @Query("page") int pageNumber);
}
