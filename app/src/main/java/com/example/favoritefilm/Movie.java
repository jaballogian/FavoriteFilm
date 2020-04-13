package com.example.favoritefilm;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {

    private String title;
    private String description;
    private String releaseDate;
    private String rating;
    private String cover;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie(){}

    public Movie(int id, String title, String description, String releaseDate, String rating, String cover){

        this.id = id;
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(releaseDate);
        dest.writeString(rating);
        dest.writeString(cover);
    }

    protected Movie(Parcel in) {
        id = in.readInt();
        title = in.readString();
        description = in.readString();
        releaseDate = in.readString();
        rating = in.readString();
        cover = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
