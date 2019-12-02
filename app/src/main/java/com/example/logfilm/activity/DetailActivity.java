package com.example.logfilm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.logfilm.R;
import com.example.logfilm.adapter.HorizontalListFilmAdapter;
import com.example.logfilm.adapter.HorizontalListTvShowAdapter;
import com.example.logfilm.data.DataFilm;
import com.example.logfilm.data.DataTvShow;
import com.example.logfilm.model.Film;
import com.example.logfilm.model.TvShow;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_FILM = "extra_film";
    public static final String EXTRA_TVSHOW = "extra_tvshow";

    private ImageView ivBgPoster, ivPoster;
    private TextView tvJudul, tvRilis, tvGenre, tvDurasi, tvSutradara, tvGolongan, tvRating, tvStatusSuka, tvSinopsis;
    private RatingBar rbRating;
    private Button btSuka;

    private RecyclerView rvReferensiLain;
    private ArrayList<Film> listFilm = new ArrayList<>();
    private ArrayList<TvShow> listTvShow = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        rvReferensiLain = findViewById(R.id.rvReferensiLain);
        rvReferensiLain.setHasFixedSize(true);

        Film film = getIntent().getParcelableExtra(EXTRA_FILM);
        TvShow tvShow = getIntent().getParcelableExtra(EXTRA_TVSHOW);

        if (film != null) {
            listFilm.addAll(DataFilm.getListData());
            showRecyclerList();
        } else if (tvShow != null) {
            listTvShow.addAll(DataTvShow.getListData());
            showRecyclerList();
        }

        //tombol back
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ivBgPoster = findViewById(R.id.background_poster);
        ivPoster = findViewById(R.id.detailPoster);
        btSuka = findViewById(R.id.btnSuka);
        tvStatusSuka = findViewById(R.id.tv_status_suka);
        tvJudul = findViewById(R.id.detailJudul);
        tvRilis = findViewById(R.id.detailRilis);
        tvGenre = findViewById(R.id.detailGenre);
        tvDurasi = findViewById(R.id.detailDurasi);
        tvSutradara = findViewById(R.id.detailSutradara);
        tvGolongan = findViewById(R.id.detailGolongan);
        tvRating = findViewById(R.id.detailRatingText);
        rbRating = findViewById(R.id.detailRating);
        tvSinopsis = findViewById(R.id.detailSinopsis);

        if (film != null) {
            int poster = film.getPoster();
            String judul = film.getJudul();
            String rilis = film.getRilis();
            int genre = film.getGenre();
            int durasi = film.getDurasi();
            String sutradara = film.getSutradara();
            int golongan = film.getGolongan();
            float rating = film.getRating();
            int sinopsis = film.getSinopsis();

            aksiSuka(judul);

            showDetail(poster, judul, rilis, genre, durasi, sutradara, golongan, rating, sinopsis);

        } else if (tvShow != null) {

            int poster = tvShow.getPoster();
            final String judul = tvShow.getJudul();
            String rilis = tvShow.getRilis();
            int genre = tvShow.getGenre();
            int durasi = tvShow.getDurasi();
            String sutradara = tvShow.getSutradara();
            int golongan = tvShow.getGolongan();
            float rating = tvShow.getRating();
            int sinopsis = tvShow.getSinopsis();

            aksiSuka(judul);

            showDetail(poster, judul, rilis, genre, durasi, sutradara, golongan, rating, sinopsis);
        }
    }

    private void showRecyclerList() {
        Film film = getIntent().getParcelableExtra(EXTRA_FILM);
        TvShow tvShow = getIntent().getParcelableExtra(EXTRA_TVSHOW);

        if (film != null) {
            rvReferensiLain.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            HorizontalListFilmAdapter listFilmAdapter = new HorizontalListFilmAdapter(listFilm);
            rvReferensiLain.setAdapter(listFilmAdapter);

            listFilmAdapter.setOnItemClickAction(new HorizontalListFilmAdapter.OnItemClickAction() {
                @Override
                public void onItemClicked(Film data) {
                    showSelectedFilm(data);
                }
            });
        } else if (tvShow != null) {
            rvReferensiLain.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            HorizontalListTvShowAdapter listTvShowAdapter = new HorizontalListTvShowAdapter(listTvShow);
            rvReferensiLain.setAdapter(listTvShowAdapter);

            listTvShowAdapter.setOnItemClickAction(new HorizontalListTvShowAdapter.OnItemClickAction() {
                @Override
                public void onItemClicked(TvShow data) {
                    showSelectedTvShow(data);
                }
            });
        }
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

        Intent pindahObjek = new Intent(this, DetailActivity.class);
        pindahObjek.putExtra(DetailActivity.EXTRA_FILM, film);
        finish();
        startActivity(pindahObjek);
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

        Intent pindahObjek = new Intent(this, DetailActivity.class);
        pindahObjek.putExtra(DetailActivity.EXTRA_TVSHOW, tvshow);
        finish();
        startActivity(pindahObjek);
    }

    private void aksiSuka(final String judul) {
        btSuka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvStatusSuka.getText().toString().equals(getString(R.string.suka))) {
                    btSuka.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icons8_love_96px_pink, 0, 0);
                    tvStatusSuka.setText(R.string.status_suka);
                    Toast.makeText(getApplicationContext(), getString(R.string.toast_suka) + judul, Toast.LENGTH_SHORT).show();
                } else {
                    btSuka.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icons8_love_96px, 0, 0);
                    tvStatusSuka.setText(R.string.suka);
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    private void showDetail(int poster, String judul, String rilis, int genre, int durasi, String sutradara, int golongan, float rating, int sinopsis) {
        ivBgPoster.setImageResource(poster);
        ivPoster.setImageResource(poster);
        tvJudul.setText(judul);
        tvRilis.setText(rilis);
        tvGenre.setText(genre);
        tvDurasi.setText(durasi);
        tvSutradara.setText(sutradara);
        tvGolongan.setText(golongan);
        tvRating.setText(String.valueOf(rating));
        rbRating.setRating(rating);
        tvSinopsis.setText(sinopsis);
    }
}
