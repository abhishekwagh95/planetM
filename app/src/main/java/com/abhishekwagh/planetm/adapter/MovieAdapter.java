package com.abhishekwagh.planetm.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abhishekwagh.planetm.R;
import com.abhishekwagh.planetm.activities.MovieDetails;
import com.abhishekwagh.planetm.models.Movie;
import com.abhishekwagh.planetm.viewholder.ViewHolder;
import com.bumptech.glide.Glide;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<ViewHolder> {
    Context mContext;
    ArrayList<Movie> mList = new ArrayList<>();

    public MovieAdapter(Context mContext, ArrayList<Movie> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    public void setData(ArrayList<Movie> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.movie_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = mList.get(position);
        holder.textView.setText(movie.getOriginal_title());
        Picasso.with(mContext)
                .load("https://image.tmdb.org/t/p/w500" + movie.getPoster_path())
                .into(holder.imageView);
        holder.imageView.setOnClickListener(v -> {
            Intent intent = new Intent(mContext, MovieDetails.class);
            intent.putExtra("original_title", movie.getOriginal_title());
            intent.putExtra("overview", movie.getOverview());
            intent.putExtra("backdrop_path", movie.getBackdrop_path());
            intent.putExtra("vote_average", movie.getVote_average().toString());
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}