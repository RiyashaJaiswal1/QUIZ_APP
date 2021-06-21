package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class MainActivity extends AppCompatActivity {

    private Button startBtn,bookmarkBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startBtn = findViewById(R.id.start_btn);
        bookmarkBtn = findViewById(R.id.bookmarks_btn);





        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override

            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });



        loadAds();



        startBtn.setOnClickListener(v -> {
            Intent i=new Intent(MainActivity.this,CategoriesActivity.class);
            startActivity(i);
        });


  bookmarkBtn.setOnClickListener(v -> {
      Intent b=new Intent(MainActivity.this,BookmarkActivity.class);
      startActivity(b);
  });


    }

    private void loadAds(){
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}