package com.example.favoritefilm;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder> {

    private ArrayList<Movie> listFavorite = new ArrayList<>();
    private Activity activity;

    public FavoriteAdapter(Activity activity) {
        this.activity = activity;
    }

    public ArrayList<Movie> getListFavorite() {
        return listFavorite;
    }

    public void setListFavorite(ArrayList<Movie> listFavorite) {
        if (listFavorite.size() > 0) {
            this.listFavorite.clear();
        }
        this.listFavorite.addAll(listFavorite);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FavoriteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_favorite, viewGroup, false);
        return new FavoriteViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull FavoriteViewHolder holder, int position) {
        holder.favoriteTitle.setText(listFavorite.get(position).getTitle());
        holder.favoriteDescription.setText(listFavorite.get(position).getDescription());
        holder.favoriteReleaseDate.setText(listFavorite.get(position).getReleaseDate());
        holder.favoriteRating.setText(listFavorite.get(position).getRating());

        Glide.with(holder.itemView.getContext())
        .load(listFavorite.get(position).getCover())
//                .apply(new RequestOptions().override(55, 55))
        .into(holder.favoriteCover);

        holder.favoriteCardView.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
//                Intent intent = new Intent(activity, FavoriteDetailActivity.class);
//                intent.putExtra(FavoriteDetailActivity.EXTRA_POSITION, position);
//                intent.putExtra(FavoriteDetailActivity.EXTRA_MOVIE, listFavorite.get(position));
//                activity.startActivityForResult(intent, FavoriteDetailActivity.REQUEST_UPDATE);
            }
        }));
    }
    @Override
    public int getItemCount() {
        return listFavorite.size();
    }

    class FavoriteViewHolder extends RecyclerView.ViewHolder {
        final TextView favoriteTitle, favoriteDescription, favoriteReleaseDate, favoriteRating;
        final ImageView favoriteCover;
        final CardView favoriteCardView;

        FavoriteViewHolder(View itemView) {
            super(itemView);
            favoriteTitle = itemView.findViewById(R.id.movieTitleTextViewItemFavorite);
            favoriteDescription = itemView.findViewById(R.id.movieDescriptionTextViewItemFavorite);
            favoriteReleaseDate = itemView.findViewById(R.id.movieDateTextViewItemFavorite);
            favoriteRating = itemView.findViewById(R.id.movieRatingTextViewItemFavorite);
            favoriteCover = itemView.findViewById(R.id.movieCoverImageViewItemFavorite);
            favoriteCardView = itemView.findViewById(R.id.cardViewItemFavorite);
        }
    }

    public void addItem(Movie movie) {
        this.listFavorite.add(movie);
        notifyItemInserted(listFavorite.size() - 1);
    }
    public void updateItem(int position, Movie movie) {
        this.listFavorite.set(position, movie);
        notifyItemChanged(position, movie);
    }
    public void removeItem(int position) {
        this.listFavorite.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,listFavorite.size());
    }
}
