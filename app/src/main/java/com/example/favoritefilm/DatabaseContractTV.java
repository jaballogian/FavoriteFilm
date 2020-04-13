package com.example.favoritefilm;

import android.net.Uri;
import android.provider.BaseColumns;

public class DatabaseContractTV {

    public static final String AUTHORITY = "com.example.submission1moviecatalogue.TV";
    private static final String SCHEME = "content";

    static String TABLE_NAME = "tv";
    static final class TVColumns implements BaseColumns {

        static String TITLE = "title";
        static String DESCRIPTION = "description";
        static String RELEASE_DATE = "release_date";
        static String RATING = "rating";
        static String COVER = "cover";

        public static final Uri CONTENT_URI_TV = new Uri.Builder().scheme(SCHEME)
                .authority(AUTHORITY)
                .appendPath(TABLE_NAME)
                .build();
    }
}
