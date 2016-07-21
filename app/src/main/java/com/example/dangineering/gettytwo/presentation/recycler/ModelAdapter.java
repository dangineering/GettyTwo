package com.example.dangineering.gettytwo.presentation.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dangineering.gettytwo.R;
import com.example.dangineering.gettytwo.presentation.viewmodel.ImageViewModel;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;

public class ModelAdapter extends RecyclerView.Adapter<ImageViewHolder> {

    // interface for click
    public interface OnItemClickListener {
        void onItemClick(ImageViewModel i);
    }

    List<ImageViewModel> data;
    OnItemClickListener listener;

    public ModelAdapter(OnItemClickListener listener) {

        data = new ArrayList<>();
        this.listener= listener;
    }


    public void setData(List<ImageViewModel> i) {
        data = i;
        notifyDataSetChanged();
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        ImageViewModel i = data.get(position);

        holder.bind(i, listener);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
