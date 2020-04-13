package com.example.favoritefilm;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FavoriteSectionsPagerAdapter extends FragmentPagerAdapter {

    private final Context mContext;
    public FavoriteSectionsPagerAdapter(FragmentManager fm, Context mContext) {
        super(fm);
        this.mContext = mContext;
    }

    @StringRes
    private final int[] TAB_TITLES = new int[]{
            R.string.favorite_movies,
            R.string.favorite_tv_shows
    };

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new FavoriteMoviesFragment();
                break;
            case 1:
                fragment = new FavoriteTVShowsFragment();
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }


    @Override
    public int getCount() {
        return 2;
    }
}
