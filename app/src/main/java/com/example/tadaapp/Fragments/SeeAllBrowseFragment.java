package com.example.tadaapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tadaapp.R;
import com.example.tadaapp.databinding.FragmentSeeAllBrowseBinding;


public class SeeAllBrowseFragment extends Fragment {

    FragmentSeeAllBrowseBinding binding;

    public void colorChanger(String btnName)
    {
        switch (btnName) {
            case "popular":
                binding.popularBtn.setBackgroundResource(R.drawable.txt_bg_selected);
                binding.fashionBtn.setBackgroundResource(R.drawable.txt_bg);
                binding.beautyBtn.setBackgroundResource(R.drawable.txt_bg);
                binding.groceryBtn.setBackgroundResource(R.drawable.txt_bg);
                break;
            case "fashion":
                binding.popularBtn.setBackgroundResource(R.drawable.txt_bg);
                binding.fashionBtn.setBackgroundResource(R.drawable.txt_bg_selected);
                binding.beautyBtn.setBackgroundResource(R.drawable.txt_bg);
                binding.groceryBtn.setBackgroundResource(R.drawable.txt_bg);
                break;
            case "beauty":
                binding.popularBtn.setBackgroundResource(R.drawable.txt_bg);
                binding.fashionBtn.setBackgroundResource(R.drawable.txt_bg);
                binding.beautyBtn.setBackgroundResource(R.drawable.txt_bg_selected);
                binding.groceryBtn.setBackgroundResource(R.drawable.txt_bg);
                break;
            case "grocery":
                binding.popularBtn.setBackgroundResource(R.drawable.txt_bg);
                binding.fashionBtn.setBackgroundResource(R.drawable.txt_bg);
                binding.beautyBtn.setBackgroundResource(R.drawable.txt_bg);
                binding.groceryBtn.setBackgroundResource(R.drawable.txt_bg_selected);
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSeeAllBrowseBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

      //  binding.popularBtn.setBackground(R.drawable.txt_bg_selected);

        assert getFragmentManager() != null;
        FragmentTransaction transaction= getFragmentManager().beginTransaction();
        transaction.replace(R.id.container,new BrowsePopularFragment()).commit();

        binding.popularBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assert getFragmentManager() != null;
                FragmentTransaction transaction= getFragmentManager().beginTransaction();
                transaction.replace(R.id.container,new BrowsePopularFragment()).commit();
                colorChanger("popular");
            }
        });

        binding.beautyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assert getFragmentManager() != null;
                FragmentTransaction transaction= getFragmentManager().beginTransaction();
                transaction.replace(R.id.container,new BrowseBeautyFragment()).commit();
                colorChanger("beauty");
            }
        });

        binding.fashionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assert getFragmentManager() != null;
                FragmentTransaction transaction= getFragmentManager().beginTransaction();
                transaction.replace(R.id.container,new BrowseFashionFragment()).commit();
                colorChanger("fashion");
            }
        });

        binding.groceryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assert getFragmentManager() != null;
                FragmentTransaction transaction= getFragmentManager().beginTransaction();
                transaction.replace(R.id.container,new BrowseGroceryFragment()).commit();
                colorChanger("grocery");
            }
        });



        return view;
    }
}