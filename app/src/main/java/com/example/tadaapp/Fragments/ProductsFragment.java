package com.example.tadaapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tadaapp.R;
import com.example.tadaapp.databinding.FragmentProductsBinding;


public class ProductsFragment extends Fragment {
    FragmentProductsBinding binding;

    public void colourChange(String Name) {
        switch (Name) {
            case "Men":
                binding.menBtn.setBackgroundResource(R.drawable.txt_bg_selected);
                binding.womenBtn.setBackgroundResource(R.drawable.txt_bg);
                binding.kidsBtn.setBackgroundResource(R.drawable.txt_bg);
                binding.groceryBtn.setBackgroundResource(R.drawable.txt_bg);
                break;
            case "Women":
                binding.womenBtn.setBackgroundResource(R.drawable.txt_bg_selected);
                binding.menBtn.setBackgroundResource(R.drawable.txt_bg);
                binding.kidsBtn.setBackgroundResource(R.drawable.txt_bg);
                binding.groceryBtn.setBackgroundResource(R.drawable.txt_bg);
                break;
            case "Kids":
                binding.kidsBtn.setBackgroundResource(R.drawable.txt_bg_selected);
                binding.menBtn.setBackgroundResource(R.drawable.txt_bg);
                binding.womenBtn.setBackgroundResource(R.drawable.txt_bg);
                binding.groceryBtn.setBackgroundResource(R.drawable.txt_bg);
                break;
            case "Grocery":
                binding.groceryBtn.setBackgroundResource(R.drawable.txt_bg_selected);
                binding.menBtn.setBackgroundResource(R.drawable.txt_bg);
                binding.womenBtn.setBackgroundResource(R.drawable.txt_bg);
                binding.kidsBtn.setBackgroundResource(R.drawable.txt_bg);
                break;

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProductsBinding.inflate(inflater, container, false);
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.secondHome, new ProMenFragment()).commit();
        colourChange("Men");

        binding.menBtn.setOnClickListener(view -> {
            FragmentTransaction transaction1 = getParentFragmentManager().beginTransaction();
            transaction1.replace(R.id.secondHome, new ProMenFragment()).commit();
            colourChange("Men");
        });
        binding.womenBtn.setOnClickListener(view -> {
            FragmentTransaction transaction1 = getParentFragmentManager().beginTransaction();
            transaction1.replace(R.id.secondHome, new ProWomenFragment()).commit();
            colourChange("Women");
        });

        binding.kidsBtn.setOnClickListener(view1 -> {
            FragmentTransaction transaction1 = getParentFragmentManager().beginTransaction();
            transaction1.replace(R.id.secondHome, new ProKidsFragment()).commit();
            colourChange("Kids");
        });
        binding.groceryBtn.setOnClickListener(view -> {
            FragmentTransaction transaction1 = getParentFragmentManager().beginTransaction();
            transaction1.replace(R.id.secondHome, new ProGroceryFragment()).commit();
            colourChange("Grocery");
        });

        return binding.getRoot();
    }
}