package com.gavblaze.android.travelstories;

import android.arch.lifecycle.LiveData;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;

import com.gavblaze.android.travelstories.models.TravelStory;

public class TravelStoryRepository {
    private LiveData<PagedList<TravelStory>> mTravelStoryList;

    public LiveData<PagedList<TravelStory>> getTravelStoryList() {

        TravelStoryDataSourceFactory dataSourceFactory = new TravelStoryDataSourceFactory();

        // If you'd like more control over when the Paging Library loads a list from your app's database
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(TravelStoryDataSource.ITEMS_PER_PAGE)
                .build();

        mTravelStoryList = new LivePagedListBuilder<>(dataSourceFactory, config).build();

        return mTravelStoryList;
    }
}
