package com.abhishekwagh.planetm.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abhishekwagh.planetm.R;


public class ViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView textView;
    public TextView rating;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.movie_image);
        textView = itemView.findViewById(R.id.movie_name);
        rating = itemView.findViewById(R.id.rating);
    }
}