package com.hiy.hiyplayer;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import me.drakeet.multitype.ItemViewBinder;

public abstract class StringViewProvider extends ItemViewBinder<String, StringViewHolder> {


    public abstract void onViewHolderClick(RecyclerView.ViewHolder holder, int index);

    @NonNull
    @Override
    protected StringViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_string, parent, false);
        return new StringViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull StringViewHolder viewHolder, @NonNull String s) {
        ((TextView) viewHolder.itemView).setText(s);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onViewHolderClick(viewHolder, viewHolder.getAdapterPosition());
            }
        });
    }
}
