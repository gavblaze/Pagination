package com.gavblaze.android.travelstories;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import com.gavblaze.android.travelstories.models.TravelStory;


public class TravelStoryViewModel extends AndroidViewModel {
    private TravelStoryRepository travelStoryRepository;

    public TravelStoryViewModel(@NonNull Application application) {
        super(application);
        travelStoryRepository = new TravelStoryRepository();
    }

    public LiveData<PagedList<TravelStory>> getTravelStoryList() {
       return travelStoryRepository.getTravelStoryList();
    }
}
