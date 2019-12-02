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
import com.example.logfilm.adapter.ListFilmAdapter;
import com.example.logfilm.data.DataFilm;
import com.example.logfilm.model.Film;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FilmFragment extends Fragment {

    private RecyclerView rvFilm;
    private ArrayList<Film> listFilm = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_film, container, false);

        rvFilm = view.findViewById(R.id.rvFilm);
        rvFilm.setHasFixedSize(true);

        listFilm.addAll(DataFilm.getListData());
        showRecyclerList();
        return view;
    }

    private void showRecyclerList() {
        rvFilm.setLayoutManager(new LinearLayoutManager(getContext()));
        ListFilmAdapter listFilmAdapter = new ListFilmAdapter(listFilm);
        rvFilm.setAdapter(listFilmAdapter);

        listFilmAdapter.setOnItemClickAction(new ListFilmAdapter.OnItemClickAction() {
            @Override
            public void onItemClicked(Film data) {
                showSelectedFilm(data);
            }
        });
    }

    private void showSelectedFilm(Film film) {
        Film logFilm = new Film();
        logFilm.setJudul(film.getJudul());
        logFilm.setPoster(film.getPoster());
        logFilm.setGenre(film.getGenre());
        logFilm.setRilis(film.getRilis());
        logFilm.setDurasi(film.getDurasi());
        logFilm.setSutradara(film.getSutradara());
        logFilm.setGolongan(film.getGolongan());
        logFilm.setRating(film.getRating());
        logFilm.setSinopsis(film.getSinopsis());

        Intent pindahObjek = new Intent(getActivity(), DetailActivity.class);
        pindahObjek.putExtra(DetailActivity.EXTRA_FILM, film);
        startActivity(pindahObjek);
    }
}
