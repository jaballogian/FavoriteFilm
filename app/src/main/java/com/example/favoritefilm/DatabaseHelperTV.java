package com.example.favoritefilm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelperTV extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "databaseTVApp";
    private static final int DATABASE_VERSION = 1;
    private static final String SQL_CREATE_TABLE_MOVIE = String.format("CREATE TABLE %s"
                    + " (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL)",
            DatabaseContractTV.TABLE_NAME,
            DatabaseContractTV.TVColumns._ID,
            DatabaseContractTV.TVColumns.TITLE,
            DatabaseContractTV.TVColumns.DESCRIPTION,
            DatabaseContractTV.TVColumns.RELEASE_DATE,
            DatabaseContractTV.TVColumns.RATING,
            DatabaseContractTV.TVColumns.COVER
    );

    public DatabaseHelperTV(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_TABLE_MOVIE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + DatabaseContractTV.TABLE_NAME);
        onCreate(db);
    }
}
