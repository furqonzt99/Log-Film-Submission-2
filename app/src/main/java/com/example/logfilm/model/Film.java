package com.example.logfilm.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Film implements Parcelable {
    public static final Creator<Film> CREATOR = new Parcelable.Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel source) {
            return new Film(source);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };
    private String judul;
    private String rilis;
    private int poster;
    private int genre;
    private int durasi;
    private String sutradara;
    private int golongan;
    private float rating;
    private int sinopsis;

    public Film() {
    }

    protected Film(Parcel in) {
        this.judul = in.readString();
        this.rilis = in.readString();
        this.poster = in.readInt();
        this.genre = in.readInt();
        this.durasi = in.readInt();
        this.sutradara = in.readString();
        this.golongan = in.readInt();
        this.rating = in.readFloat();
        this.sinopsis = in.readInt();
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getRilis() {
        return rilis;
    }

    public void setRilis(String rilis) {
        this.rilis = rilis;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public int getDurasi() {
        return durasi;
    }

    public void setDurasi(int durasi) {
        this.durasi = durasi;
    }

    public String getSutradara() {
        return sutradara;
    }

    public void setSutradara(String sutradara) {
        this.sutradara = sutradara;
    }

    public int getGolongan() {
        return golongan;
    }

    public void setGolongan(int golongan) {
        this.golongan = golongan;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(int sinopsis) {
        this.sinopsis = sinopsis;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judul);
        dest.writeString(this.rilis);
        dest.writeInt(this.poster);
        dest.writeInt(this.genre);
        dest.writeInt(this.durasi);
        dest.writeString(this.sutradara);
        dest.writeInt(this.golongan);
        dest.writeFloat(this.rating);
        dest.writeInt(this.sinopsis);
    }
}
