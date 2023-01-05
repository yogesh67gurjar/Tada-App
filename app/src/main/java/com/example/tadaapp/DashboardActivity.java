package com.example.tadaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.media.Image;
import android.os.Bundle;
import android.text.TextPaint;

import com.example.tadaapp.Adapters.DbImageSliderAdapter;
import com.example.tadaapp.Fragments.HomeFragment;
import com.example.tadaapp.Fragments.MessageFragment;
import com.example.tadaapp.Fragments.OrderFragment;
import com.example.tadaapp.Fragments.ProfileFragment;
import com.example.tadaapp.Fragments.SearchFragment;
import com.example.tadaapp.Modal.ImageModel;
import com.example.tadaapp.databinding.ActivityDashboardBinding;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    ActivityDashboardBinding binding;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        // this line is for showing home fragment by default on the dashboard
        getSupportFragmentManager().beginTransaction().replace(R.id.cons_layout, new HomeFragment()).commit();

        binding.navView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {

                case R.id.home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.cons_layout, new HomeFragment()).commit();
                    break;
                case R.id.search:
                    getSupportFragmentManager().beginTransaction().replace(R.id.cons_layout, new SearchFragment()).commit();
                    break;
                case R.id.profile:
                    getSupportFragmentManager().beginTransaction().replace(R.id.cons_layout, new ProfileFragment()).commit();
                    break;
                case R.id.message:
                    getSupportFragmentManager().beginTransaction().replace(R.id.cons_layout, new MessageFragment()).commit();
                    break;
                case R.id.orders:
                    getSupportFragmentManager().beginTransaction().replace(R.id.cons_layout, new OrderFragment()).commit();
                    break;
            }
            return true;
        });
    }
}