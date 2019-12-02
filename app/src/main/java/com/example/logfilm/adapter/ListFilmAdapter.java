package com.example.logfilm.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.logfilm.R;
import com.example.logfilm.model.Film;

import java.util.ArrayList;

public class ListFilmAdapter extends RecyclerView.Adapter<ListFilmAdapter.ListViewHolder> {
    public static final String EXTRA_FILM = "extra_film";
    private ArrayList<Film> listFilm;
    private ListFilmAdapter.OnItemClickAction onItemClickAction;

    public ListFilmAdapter(ArrayList<Film> listfilm) {
        this.listFilm = listfilm;
    }

    public void setOnItemClickAction(OnItemClickAction onItemClickAction) {
        this.onItemClickAction = onItemClickAction;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listview, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Film film = listFilm.get(position);

        Glide.with((holder.itemView.getContext()))
                .load(film.getPoster())
                .apply(new RequestOptions())
                .into(holder.filmPoster);

        holder.filmJudul.setText(film.getJudul());
        holder.filmGenre.setText(film.getGenre());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickAction.onItemClicked(listFilm.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listFilm.size();
    }

    public interface OnItemClickAction {
        void onItemClicked(Film data);
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout filmList;
        ImageView filmPoster;
        TextView filmJudul, filmGenre;

        ListViewHolder(View itemView) {
            super(itemView);
            filmList = itemView.findViewById(R.id.itemList);
            filmJudul = itemView.findViewById(R.id.listJudul);
            filmGenre = itemView.findViewById(R.id.listGenre);
            filmPoster = itemView.findViewById(R.id.listPoster);
        }
    }
}
