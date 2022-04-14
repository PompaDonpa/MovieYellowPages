package com.example.movieyellowpages.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieyellowpages.Listenres.OnMovieClickListener;
import com.example.movieyellowpages.R;
import com.example.movieyellowpages.models.SearchArrayObject;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeViewHolder>{

    Context context;
    List<SearchArrayObject> list;
    OnMovieClickListener listener;


    public HomeRecyclerAdapter(Context context, List<SearchArrayObject> list, OnMovieClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeViewHolder(LayoutInflater.from(context).inflate(R.layout.home_movies_list, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        holder.textViewMovie.setText(list.get(position).getTitle());
        Picasso.get().load(list.get(position).getPoster_path()).into(holder.imageViewPoster);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class HomeViewHolder extends RecyclerView.ViewHolder {

    ImageView imageViewPoster;
    TextView textViewMovie;
    CardView homeContainer;

    public HomeViewHolder(@NonNull View itemView) {
        super(itemView);
        imageViewPoster = itemView.findViewById(R.id.imageView_poster);
        textViewMovie = itemView.findViewById(R.id.textView_movie);
        homeContainer = itemView.findViewById(R.id.home_container);
    }
}
