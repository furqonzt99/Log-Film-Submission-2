package com.example.logfilm.data;

import com.example.logfilm.R;
import com.example.logfilm.model.TvShow;

import java.util.ArrayList;

public class DataTvShow {

    private static String[] judulTvShow = {
            "Dragon Ball",
            "Fairy Tail",
            "Family Guy",
            "The Flash",
            "Gotham",
            "Iron Fist",
            "Naruto Shippuden",
            "Shameless",
            "Supergirl",
            "The Simpson"
    };

    private static String[] rilisTvShow = {
            "1986",
            "2009",
            "1999",
            "2014",
            "2014",
            "2017",
            "2007",
            "2011",
            "2015",
            "1989"
    };

    private static int[] posterTvShow = {
            R.drawable.poster_dragon_ball,
            R.drawable.poster_fairytail,
            R.drawable.poster_family_guy,
            R.drawable.poster_flash,
            R.drawable.poster_gotham,
            R.drawable.poster_iron_fist,
            R.drawable.poster_naruto_shipudden,
            R.drawable.poster_shameless,
            R.drawable.poster_supergirl,
            R.drawable.poster_the_simpson
    };

    private static int[] genreTvShow = {
            R.string.dragonball_genre,
            R.string.fairytail_genre,
            R.string.family_guy_genre,
            R.string.flash_genre,
            R.string.gotham_genre,
            R.string.iron_fist_genre,
            R.string.narutoshippuden_genre,
            R.string.shameless_genre,
            R.string.supergirl_genre,
            R.string.thesimpson_genre
    };

    private static int[] durasiTvShow = {
            R.string.dragonball_durasi,
            R.string.fairytail_durasi,
            R.string.family_guy_durasi,
            R.string.flash_durasi,
            R.string.gotham_durasi,
            R.string.iron_fist_durasi,
            R.string.narutoshippuden_durasi,
            R.string.shameless_durasi,
            R.string.supergirl_durasi,
            R.string.thesimpson_durasi
    };

    private static String[] sutradaraTvShow = {
            "Akira Toriyama",
            "Hiro Mashima",
            "Seth MacFarlane",
            "Greg Berlanti, Geoff Johns, Andrew Kreisberg",
            "Bruno Heller",
            "Scott Buck",
            "Masashi Kishimoto",
            "Paul Abbott",
            "Ali Adler, Greg Berlanti, Andrew Kreisberg",
            "Matt Groening"
    };

    private static int[] golonganTvShow = {
            R.string.semua_umur_golongan,
            R.string.tujuh_belas_plus_golongan,
            R.string.semua_umur_golongan,
            R.string.tiga_belas_plus_golongan,
            R.string.tujuh_belas_plus_golongan,
            R.string.tujuh_belas_plus_golongan,
            R.string.semua_umur_golongan,
            R.string.tiga_belas_plus_golongan,
            R.string.tiga_belas_plus_golongan,
            R.string.semua_umur_golongan
    };

    private static float[] ratingTvShow = {
            (float) 4.1,
            (float) 4.0,
            (float) 4.1,
            (float) 3.9,
            (float) 3.9,
            (float) 3.2,
            (float) 4.2,
            (float) 4.3,
            (float) 3.2,
            (float) 4, 4
    };

    private static int[] sinopsisTvShow = {
            R.string.dragonball_sinopsis,
            R.string.fairytail_sinopsis,
            R.string.family_guy_sinopsis,
            R.string.flash_sinopsis,
            R.string.gotham_sinopsis,
            R.string.iron_fist_sinopsis,
            R.string.narutoshippuden_sinopsis,
            R.string.shameless_sinopsis,
            R.string.supergirl_sinopsis,
            R.string.thesimpson_sinopsis
    };


    public static ArrayList<TvShow> getListData() {
        ArrayList<TvShow> list = new ArrayList<>();
        for (int position = 0; position < judulTvShow.length; position++) {
            TvShow tvshow = new TvShow();
            tvshow.setJudul(judulTvShow[position]);
            tvshow.setRilis(rilisTvShow[position]);
            tvshow.setPoster(posterTvShow[position]);
            tvshow.setGenre(genreTvShow[position]);
            tvshow.setDurasi(durasiTvShow[position]);
            tvshow.setSutradara(sutradaraTvShow[position]);
            tvshow.setGolongan(golonganTvShow[position]);
            tvshow.setRating(ratingTvShow[position]);
            tvshow.setSinopsis(sinopsisTvShow[position]);
            list.add(tvshow);
        }
        return list;
    }
}
