package com.gavblaze.android.travelstories;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;
import android.support.annotation.NonNull;

import com.gavblaze.android.travelstories.models.TravelStory;


public class TravelStoryDataSourceFactory extends DataSource.Factory<Integer, TravelStory> {
    private MutableLiveData<TravelStoryDataSource> mSourceLiveData = new MutableLiveData<>();

    @NonNull
    @Override
    public DataSource<Integer, TravelStory> create() {
        TravelStoryDataSource source = new TravelStoryDataSource();
        mSourceLiveData.postValue(source);
        return source;
    }
}
