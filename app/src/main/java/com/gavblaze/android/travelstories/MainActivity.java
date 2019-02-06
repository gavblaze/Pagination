package com.gavblaze.android.travelstories;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gavblaze.android.travelstories.models.TravelStory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);

        mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        final TravelStoryAdapter adapter = new TravelStoryAdapter();

        TravelStoryViewModel viewModel = ViewModelProviders.of(this).get(TravelStoryViewModel.class);
        viewModel.getTravelStoryList().observe(this, new Observer<PagedList<TravelStory>>() {
            @Override
            public void onChanged(@Nullable PagedList<TravelStory> travelStories) {
                adapter.submitList(travelStories);
            }
        });
        mRecyclerView.setAdapter(adapter);
    }

    public class MyBroadcast extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

        }
    }
}
