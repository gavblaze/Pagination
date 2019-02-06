package com.gavblaze.android.travelstories.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Feed {

    @SerializedName("articles")
    @Expose
    private List<TravelStory> travelStories = null;


    public List<TravelStory> getTravelStories() {
        return travelStories;
    }

    public void setTravelStories(List<TravelStory> travelStories) {
        this.travelStories = travelStories;
    }

}
