package com.example.favoritefilm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class FavoriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        FavoriteSectionsPagerAdapter favoriteSectionsPagerAdapter = new FavoriteSectionsPagerAdapter(getSupportFragmentManager(), this);
        ViewPager viewPager = findViewById(R.id.viewPagerActivityFavorite);
        viewPager.setAdapter(favoriteSectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabLayoutActivityFavorite);
        tabs.setupWithViewPager(viewPager);

        getSupportActionBar().setElevation(0);
    }
}
