package com.example.tadaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.Log;

import com.example.tadaapp.Adapters.SeeAllVpAdapter;
import com.example.tadaapp.databinding.ActivitySeeAllBinding;
import com.google.android.material.tabs.TabLayoutMediator;

public class SeeAllActivity extends AppCompatActivity {

    ActivitySeeAllBinding binding;
    SeeAllVpAdapter vpAdapter;
    String[] titles=new String[]{"Live Shopping","Browse"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySeeAllBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();


        TextPaint paint = binding.tadaLogo.getPaint();
        float width = paint.measureText("Tada");
        Shader textShader = new LinearGradient(0, 0, width, binding.tadaLogo.getTextSize(),
                new int[]{
                        Color.parseColor("#FE0187"),
                        Color.parseColor("#FF5A3A"),
                }, null, Shader.TileMode.CLAMP);
        binding.tadaLogo.getPaint().setShader(textShader);

        vpAdapter=new SeeAllVpAdapter(this);

        binding.viewpager.setAdapter(vpAdapter);

        new TabLayoutMediator(binding.tablayout,binding.viewpager,((tab, position) -> tab.setText(titles[position]))).attach();

    }
}