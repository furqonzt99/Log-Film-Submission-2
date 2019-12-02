package com.example.logfilm.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.logfilm.R;
import com.example.logfilm.activity.DetailActivity;
import com.example.logfilm.adapter.ListTvShowAdapter;
import com.example.logfilm.data.DataTvShow;
import com.example.logfilm.model.TvShow;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TVFragment extends Fragment {

    private RecyclerView rvTvShow;
    private ArrayList<TvShow> listTvShow = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tv, container, false);

        rvTvShow = view.findViewById(R.id.rvTvShow);
        rvTvShow.setHasFixedSize(true);

        listTvShow.addAll(DataTvShow.getListData());
        showRecyclerList();
        return view;
    }

    private void showRecyclerList() {
        rvTvShow.setLayoutManager(new LinearLayoutManager(getContext()));
        ListTvShowAdapter listTvShowAdapter = new ListTvShowAdapter(listTvShow);
        rvTvShow.setAdapter(listTvShowAdapter);

        listTvShowAdapter.setOnItemClickAction(new ListTvShowAdapter.OnItemClickAction() {
            @Override
            public void onItemClicked(TvShow data) {
                showSelectedTvShow(data);
            }
        });
    }

    private void showSelectedTvShow(TvShow tvshow) {
        TvShow logTvShow = new TvShow();
        logTvShow.setJudul(tvshow.getJudul());
        logTvShow.setPoster(tvshow.getPoster());
        logTvShow.setGenre(tvshow.getGenre());
        logTvShow.setRilis(tvshow.getRilis());
        logTvShow.setDurasi(tvshow.getDurasi());
        logTvShow.setSutradara(tvshow.getSutradara());
        logTvShow.setGolongan(tvshow.getGolongan());
        logTvShow.setRating(tvshow.getRating());
        logTvShow.setSinopsis(tvshow.getSinopsis());

        Intent pindahObjek = new Intent(getActivity(), DetailActivity.class);
        pindahObjek.putExtra(DetailActivity.EXTRA_TVSHOW, tvshow);
        startActivity(pindahObjek);
    }

}
