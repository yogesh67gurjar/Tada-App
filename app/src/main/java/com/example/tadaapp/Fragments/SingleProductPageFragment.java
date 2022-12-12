package com.example.tadaapp.Fragments;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;

import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tadaapp.Adapters.DbImageAdapter;
import com.example.tadaapp.Modal.DbImageModal;
import com.example.tadaapp.R;
import com.example.tadaapp.databinding.FragmentSingleProductPageBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;


public class SingleProductPageFragment extends BottomSheetDialogFragment {

    FragmentSingleProductPageBinding binding;
    DbImageAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentSingleProductPageBinding.inflate(inflater,container,false);

        TextPaint paint = binding.varTV.getPaint();
        float width = paint.measureText("View All Reviews");

        Shader textShader = new LinearGradient(0, 0, width, binding.varTV.getTextSize(),
                new int[]{
                        Color.parseColor("#FE0187"),
                        Color.parseColor("#FF5A3A"),
                }, null, Shader.TileMode.CLAMP);
        binding.varTV.getPaint().setShader(textShader);

        List<DbImageModal>listOfImages=new ArrayList<>();

        listOfImages.add(new DbImageModal(R.drawable.img_singlepro));
        listOfImages.add(new DbImageModal(R.drawable.img_singlepro));
        listOfImages.add(new DbImageModal(R.drawable.img_singlepro));
        listOfImages.add(new DbImageModal(R.drawable.img_singlepro));

        adapter=new DbImageAdapter(getContext(),listOfImages);
        binding.viewpager.setAdapter(adapter);

        binding.tablayout.setupWithViewPager(binding.viewpager);



        return binding.getRoot();
    }
}