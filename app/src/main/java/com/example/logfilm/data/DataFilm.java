package com.example.logfilm.data;

import com.example.logfilm.R;
import com.example.logfilm.model.Film;

import java.util.ArrayList;

public class DataFilm {

    private static String[] judulFilm = {
            "Aquaman",
            "Avengers: Infinity War",
            "Deadpool 2",
            "How to Train Your Dragon: The Hidden World",
            "Glass",
            "Mortal Engines",
            "Preman Pensiun",
            "Spider-Man: Into the Spider-Verse",
            "The Mule",
            "Venom"
    };

    private static String[] rilisFilm = {
            "2018",
            "2018",
            "2018",
            "2019",
            "2019",
            "2018",
            "2019",
            "2018",
            "2018",
            "2018"
    };

    private static int[] posterFilm = {
            R.drawable.poster_aquaman,
            R.drawable.poster_avengerinfinity,
            R.drawable.poster_deadpool,
            R.drawable.poster_dragon,
            R.drawable.poster_glass,
            R.drawable.poster_mortalengine,
            R.drawable.poster_preman,
            R.drawable.poster_spiderman,
            R.drawable.poster_themule,
            R.drawable.poster_venom
    };

    private static int[] genreFilm = {
            R.string.aquaman_genre,
            R.string.avengers_genre,
            R.string.deadpool_genre,
            R.string.dragon_genre,
            R.string.glass_genre,
            R.string.mortalengine_genre,
            R.string.preman_genre,
            R.string.spiderman_genre,
            R.string.mule_genre,
            R.string.venom_genre
    };

    private static int[] durasiFilm = {
            R.string.aquaman_durasi,
            R.string.avengers_durasi,
            R.string.deadpool_durasi,
            R.string.dragon_durasi,
            R.string.glass_durasi,
            R.string.mortalengine_durasi,
            R.string.preman_durasi,
            R.string.spiderman_durasi,
            R.string.mule_durasi,
            R.string.venom_durasi
    };

    private static String[] sutradaraFilm = {
            "James Wan",
            "Anthony & Joe Russo",
            "David Leitch",
            "Dean DeBlois",
            "M. Night Shyamalan",
            "Christian Rivers",
            "Aris Nugraha",
            "Peter Ramsey",
            "Clint Eastwood",
            "Ruben Fleischer"
    };

    private static int[] golonganFilm = {
            R.string.tiga_belas_plus_golongan,
            R.string.tiga_belas_plus_golongan,
            R.string.tujuh_belas_plus_golongan,
            R.string.semua_umur_golongan,
            R.string.tiga_belas_plus_golongan,
            R.string.tujuh_belas_plus_golongan,
            R.string.tiga_belas_plus_golongan,
            R.string.semua_umur_golongan,
            R.string.tujuh_belas_plus_golongan,
            R.string.tujuh_belas_plus_golongan
    };

    private static float[] ratingFilm = {
            (float) 3.5,
            (float) 4.3,
            (float) 3.9,
            (float) 3.7,
            (float) 3.3,
            (float) 3.1,
            (float) 3.5,
            (float) 4.2,
            (float) 3.5,
            (float) 3.3
    };

    private static int[] sinopsisFilm = {
            R.string.aquaman_sinopsis,
            R.string.avengers_sinopsis,
            R.string.deadpool_sinopsis,
            R.string.dragon_sinopsis,
            R.string.glass_sinopsis,
            R.string.mortalengines_sinopsis,
            R.string.preman_sinopsis,
            R.string.spiderman_sinopsis,
            R.string.mule_sinopsis,
            R.string.venom_sinopsis
    };


    public static ArrayList<Film> getListData() {
        ArrayList<Film> list = new ArrayList<>();
        for (int position = 0; position < judulFilm.length; position++) {
            Film film = new Film();
            film.setJudul(judulFilm[position]);
            film.setRilis(rilisFilm[position]);
            film.setPoster(posterFilm[position]);
            film.setGenre(genreFilm[position]);
            film.setDurasi(durasiFilm[position]);
            film.setSutradara(sutradaraFilm[position]);
            film.setGolongan(golonganFilm[position]);
            film.setRating(ratingFilm[position]);
            film.setSinopsis(sinopsisFilm[position]);
            list.add(film);
        }
        return list;
    }
}
