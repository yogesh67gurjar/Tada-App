package com.example.tadaapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tadaapp.Adapters.SeeAllVpAdapter;
import com.example.tadaapp.Adapters.SellerProfileVpAdapter;
import com.example.tadaapp.databinding.ActivitySellerprofileBinding;
import com.google.android.material.tabs.TabLayoutMediator;

public class SellerProfileActivity extends AppCompatActivity {

    ActivitySellerprofileBinding binding;
    private String[] titles=new String[]{"Video","Store"};
    SellerProfileVpAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySellerprofileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        adapter =new SellerProfileVpAdapter(this);

        binding.container.setAdapter(adapter);

        new TabLayoutMediator(binding.tablayout,binding.container,((tab, position) -> tab.setText(titles[position]))).attach();

    }
}