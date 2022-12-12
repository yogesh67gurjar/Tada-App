package com.example.tadaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.tadaapp.Fragments.AddNewAddressFragment;
import com.example.tadaapp.databinding.ActivityShippingAddressBinding;

public class ShippingAddressActivity extends AppCompatActivity {

    ActivityShippingAddressBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityShippingAddressBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.addnewaddressTv.setOnClickListener(view -> {

            AddNewAddressFragment obj=new AddNewAddressFragment();
            obj.show(getSupportFragmentManager(),obj.getTag());
        });
    }
}