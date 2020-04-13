package com.example.favoritefilm;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import static com.example.favoritefilm.DatabaseContract.MovieColumns.CONTENT_URI;
import static com.example.favoritefilm.DatabaseContractTV.TVColumns.CONTENT_URI_TV;

public class FavoriteDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private Button deleteFromFavoriteButton;
    private Movie movie;
    private int position;
    private MovieHelper movieHelper;
    private MovieHelperTV movieHelperTV;
    private ImageView favoriteCoverImageView;
    private TextView favoriteTitleTextView, favoriteDateTextView, favoriteRatingTextView, favoriteDescriptionTextView;
    private String state = "";
    private Uri uriWithId, uriWithIDTV;

    public static final String EXTRA_MOVIE = "extra_movie";
    public static final String EXTRA_POSITION = "extra_position";
    public static final int REQUEST_ADD = 100;
    public static final int RESULT_ADD = 101;
    public static final int REQUEST_UPDATE = 200;
    public static final int RESULT_UPDATE = 201;
    public static final int RESULT_DELETE = 301;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_detail);

        favoriteCoverImageView = (ImageView) findViewById(R.id.movieCoverImageViewActivityFavoriteDetail);
        favoriteTitleTextView = (TextView) findViewById(R.id.movieTitleTextViewActivityFavoriteDetail);
        favoriteDateTextView = (TextView) findViewById(R.id.movieDateTextViewActivityFavoriteDetail);
        favoriteRatingTextView = (TextView) findViewById(R.id.movieRatingTextViewActivityFavoriteDetail);
        favoriteDescriptionTextView = (TextView) findViewById(R.id.movieDescriptionTextViewActivityFavoriteDetail);
        deleteFromFavoriteButton = (Button) findViewById(R.id.deleteFromFavoriteActivityFavoriteDetail);

        movieHelper = movieHelper.getInstance(getApplicationContext());
        movieHelperTV = movieHelperTV.getInstance(getApplicationContext());
        movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        favoriteTitleTextView.setText(movie.getTitle());
        favoriteDescriptionTextView.setText(movie.getDescription());
        favoriteRatingTextView.setText(movie.getRating());
        favoriteDateTextView.setText(movie.getReleaseDate());
        Glide.with(this)
                .load(movie.getCover())
//                .apply(new RequestOptions().override(55, 55))
                .into(favoriteCoverImageView);

        deleteFromFavoriteButton.setVisibility(View.GONE);
        deleteFromFavoriteButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.deleteFromFavoriteActivityFavoriteDetail) {

            try {

                uriWithId = Uri.parse(CONTENT_URI + "/" + movie.getId());
                Intent toFavoriteActivity = new Intent(FavoriteDetailActivity.this, FavoriteActivity.class);
                startActivity(toFavoriteActivity);
                Toast.makeText(FavoriteDetailActivity.this, getString(R.string.deleted_from_favorite), Toast.LENGTH_SHORT).show();
                getContentResolver().delete(uriWithId, null, null);

//                long result = movieHelper.deleteById(String.valueOf(movie.getId()));
//                if (result > 0) {
//                    Intent intent = new Intent(FavoriteDetailActivity.this, FavoriteActivity.class);
//                    intent.putExtra(EXTRA_POSITION, position);
//                    setResult(RESULT_DELETE, intent);
//                    Toast.makeText(this, getString(R.string.deleted_from_favorite), Toast.LENGTH_SHORT).show();
//                    state = getString(R.string.deleted_from_favorite);
//                    startActivity(intent);
//                    finish();
//                } else {
//                    state = getString(R.string.failed_to_delete_data);
//                }
            }
            catch (Exception error){

                uriWithIDTV = Uri.parse(CONTENT_URI_TV + "/" + movie.getId());
                Intent toFavoriteActivity = new Intent(FavoriteDetailActivity.this, FavoriteActivity.class);
                startActivity(toFavoriteActivity);
                Toast.makeText(FavoriteDetailActivity.this, getString(R.string.deleted_from_favorite), Toast.LENGTH_SHORT).show();
                getContentResolver().delete(uriWithIDTV, null, null);
            }

//            if (state.equals(getString(R.string.failed_to_delete_data))){
//
//                try {
//
//                    long result = movieHelperTV.deleteById(String.valueOf(movie.getId()));
//                    if (result > 0) {
//                        Intent intent = new Intent(FavoriteDetailActivity.this, FavoriteActivity.class);
//                        intent.putExtra(EXTRA_POSITION, position);
//                        setResult(RESULT_DELETE, intent);
//                        Toast.makeText(this, getString(R.string.deleted_from_favorite), Toast.LENGTH_SHORT).show();
//                        startActivity(intent);
//                        finish();
//                    }
//                }
//                catch (Exception error){
//
//                }
//            }
        }
    }
}
