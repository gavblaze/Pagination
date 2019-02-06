package com.gavblaze.android.travelstories.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TravelStory {
    @SerializedName("title")
    @Expose
    private String mTitle;
    @SerializedName("urlToImage")
    @Expose
    private String mImgUrl;


    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmImgUrl() {
        return mImgUrl;
    }

    public void setmImgUrl(String mImgUrl) {
        this.mImgUrl = mImgUrl;
    }
}
