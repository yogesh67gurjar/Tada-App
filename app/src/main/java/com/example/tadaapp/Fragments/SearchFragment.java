package com.example.tadaapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentTransactionKt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tadaapp.R;
import com.example.tadaapp.databinding.FragmentSearchBinding;

public class SearchFragment extends Fragment {

    FragmentSearchBinding binding;

    public  void colourChange(String Name){
        switch (Name){
            case "Live":
                binding.btnLive.setTextColor(getResources().getColor(R.color.appPink));
                binding.btnBrowse.setTextColor(getResources().getColor(R.color.white));
                binding.btnProducts.setTextColor(getResources().getColor(R.color.white));
                break;
            case "Browse":
                binding.btnBrowse.setTextColor(getResources().getColor(R.color.appPink));
                binding.btnLive.setTextColor(getResources().getColor(R.color.white));
                binding.btnProducts.setTextColor(getResources().getColor(R.color.white));
                break;
            case "Products":
                binding.btnProducts.setTextColor(getResources().getColor(R.color.appPink));
                binding.btnLive.setTextColor(getResources().getColor(R.color.white));
                binding.btnBrowse.setTextColor(getResources().getColor(R.color.white));
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSearchBinding.inflate(inflater,container,false);
        FragmentTransaction transaction2 = getFragmentManager().beginTransaction();
        transaction2.replace(R.id.firstHome,new LiveShoppingFragment()).commit();
        colourChange("Live");


        binding.btnLive.setOnClickListener(view -> {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.firstHome,new LiveShoppingFragment()).commit();
            colourChange("Live");
        });
        binding.btnBrowse.setOnClickListener(view -> {

            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.firstHome,new BrowseFragment()).commit();
            colourChange("Browse");
        });
        binding.btnProducts.setOnClickListener(view -> {
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.firstHome,new ProductsFragment()).commit();
            colourChange("Products");
        });



        return binding.getRoot();
    }
}