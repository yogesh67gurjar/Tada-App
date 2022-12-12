package com.example.tadaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ShoppingVideosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_videos);
        getSupportActionBar().hide();
    }
}