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
import com.example.logfilm.model.TvShow;

import java.util.ArrayList;

public class HorizontalListTvShowAdapter extends RecyclerView.Adapter<HorizontalListTvShowAdapter.ListViewHolder> {
    private ArrayList<TvShow> listTvShow;
    private OnItemClickAction onItemClickAction;

    public HorizontalListTvShowAdapter(ArrayList<TvShow> listtvshow) {
        this.listTvShow = listtvshow;
    }

    public void setOnItemClickAction(OnItemClickAction onItemClickAction) {
        this.onItemClickAction = onItemClickAction;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listview_referensi_lain, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        TvShow tvshow = listTvShow.get(position);

        Glide.with((holder.itemView.getContext()))
                .load(tvshow.getPoster())
                .apply(new RequestOptions())
                .into(holder.tvShowPoster);

        holder.tvShowJudul.setText(tvshow.getJudul());
        holder.tvShowGenre.setText(tvshow.getGenre());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickAction.onItemClicked(listTvShow.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTvShow.size();
    }

    public interface OnItemClickAction {
        void onItemClicked(TvShow data);
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout tvShowList;
        ImageView tvShowPoster;
        TextView tvShowJudul, tvShowGenre;

        ListViewHolder(View itemView) {
            super(itemView);
            tvShowList = itemView.findViewById(R.id.itemList);
            tvShowJudul = itemView.findViewById(R.id.listJudul);
            tvShowGenre = itemView.findViewById(R.id.listGenre);
            tvShowPoster = itemView.findViewById(R.id.listPoster);
        }
    }
}
