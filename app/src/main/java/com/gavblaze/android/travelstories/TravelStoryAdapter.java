package com.gavblaze.android.travelstories;


import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gavblaze.android.travelstories.models.TravelStory;
import com.squareup.picasso.Picasso;


public class TravelStoryAdapter extends PagedListAdapter<TravelStory, TravelStoryAdapter.Viewholder> {

    private static DiffUtil.ItemCallback<TravelStory> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<TravelStory>() {
                @Override
                public boolean areItemsTheSame(TravelStory oldItem, TravelStory newItem) {
                    return oldItem.getmTitle() == newItem.getmTitle();
                }

                @Override
                public boolean areContentsTheSame(TravelStory oldItem, TravelStory newItem) {
                    return oldItem.equals(newItem);
                }
            };

    protected TravelStoryAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new Viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        TravelStory travelStory = getItem(position);
        Picasso.get().load(travelStory.getmImgUrl()).into(holder.travelImage);
        holder.travelText.setText(travelStory.getmTitle());

    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private ImageView travelImage;
        private TextView travelText;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            travelImage = itemView.findViewById(R.id.travelImage);
            travelText = itemView.findViewById(R.id.travelText);
        }
    }
}
