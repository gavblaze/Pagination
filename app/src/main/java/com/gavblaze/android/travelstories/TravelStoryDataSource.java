package com.gavblaze.android.travelstories;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;

import com.gavblaze.android.travelstories.models.Feed;
import com.gavblaze.android.travelstories.models.TravelStory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TravelStoryDataSource extends PageKeyedDataSource<Integer, TravelStory> {
    public static final int ITEMS_PER_PAGE = 20;
    private static final int FIRST_PAGE = 1;
    private static String API_KEY = "079dac74a5f94ebdb990ecf61c8854b7";

    @Override
    public void loadInitial(@NonNull final LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, TravelStory> callback) {

        ApiClient.getRetrofitInstance().create(ApiEndpointInterface.class)
                .getTravelStories("travel", API_KEY, ITEMS_PER_PAGE, FIRST_PAGE).enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                if (response.body() != null) {
                    callback.onResult(response.body().getTravelStories(), null, FIRST_PAGE + 1);
                }
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {

            }
        });

    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, TravelStory> callback) {
        ApiClient.getRetrofitInstance().create(ApiEndpointInterface.class)
                .getTravelStories("travel", API_KEY, ITEMS_PER_PAGE, FIRST_PAGE).enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                if (response.body() != null) {
                    Integer key = null;
                    if (params.key > 1) {         // are we on a page greater than 1? If yes decrement the page!
                        key = params.key - 1;
                    }
                    callback.onResult(response.body().getTravelStories(), key);
                }
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, TravelStory> callback) {
        ApiClient.getRetrofitInstance().create(ApiEndpointInterface.class)
                .getTravelStories("travel", API_KEY, ITEMS_PER_PAGE, FIRST_PAGE).enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                if (response.body() != null) {
                    Integer key = params.key + 1;
                    callback.onResult(response.body().getTravelStories(), key);
                }
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
            }
        });
    }
}
