package com.example.favoritefilm;

import android.database.Cursor;

import java.util.ArrayList;

public class MappingHelper {

    public static ArrayList<Movie> mapCursorToArrayList(Cursor notesCursor) {
        ArrayList<Movie> movieList = new ArrayList<>();
        while (notesCursor.moveToNext()) {
            int id = notesCursor.getInt(notesCursor.getColumnIndexOrThrow(DatabaseContract.MovieColumns._ID));
            String title = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.MovieColumns.TITLE));
            String description = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.MovieColumns.DESCRIPTION));
            String releaseDate = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.MovieColumns.RELEASE_DATE));
            String rating = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.MovieColumns.RATING));
            String cover = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.MovieColumns.COVER));
            movieList.add(new Movie(id, title, description, releaseDate, rating, cover));
        }
        return movieList;
    }

    public static ArrayList<String> mapCursorToString(Cursor notesCursor) {
        ArrayList<String> strings = new ArrayList<>();
        while (notesCursor.moveToNext()) {
            String string = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.MovieColumns.TITLE));
            strings.add(string);
        }
        return strings;
    }

    public static ArrayList<String> mapCursorToStringImage(Cursor notesCursor) {
        ArrayList<String> strings = new ArrayList<>();
        while (notesCursor.moveToNext()) {
            String stringImage = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.MovieColumns.COVER));
            strings.add(stringImage);
        }
        return strings;
    }

    public static Movie mapCursorToObject(Cursor notesCursor) {
        notesCursor.moveToFirst();
        int id = notesCursor.getInt(notesCursor.getColumnIndexOrThrow(DatabaseContract.MovieColumns._ID));
        String title = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.MovieColumns.TITLE));
        String description = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.MovieColumns.DESCRIPTION));
        String releaseDate = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.MovieColumns.RELEASE_DATE));
        String rating = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.MovieColumns.RATING));
        String cover = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.MovieColumns.COVER));
        return new Movie(id, title, description, releaseDate, rating, cover);
    }
}
