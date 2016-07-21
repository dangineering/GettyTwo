package com.example.dangineering.gettytwo.presentation.recycler;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dangineering.gettytwo.R;
import com.example.dangineering.gettytwo.presentation.viewmodel.ImageViewModel;
import com.squareup.picasso.Picasso;

public class ImageViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView textView;
    Context context;


    public ImageViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.pic_image);
        textView = (TextView) itemView.findViewById(R.id.title_text);
        this.context = itemView.getContext();

    }

    public void bind(final ImageViewModel i, final ModelAdapter.OnItemClickListener o) {
        Picasso.with(context).load(i.getUrl()).into(imageView);
        textView.setText(i.getTitle());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                o.onItemClick(i);
            }
        });
    }

}
