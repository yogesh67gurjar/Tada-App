package com.example.tadaapp.Fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;

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

        List<DbImageModal>listOfImages=new ArrayList<>();

        listOfImages.add(new DbImageModal(R.drawable.img_singlepro));
        listOfImages.add(new DbImageModal(R.drawable.img_singlepro));
        listOfImages.add(new DbImageModal(R.drawable.img_singlepro));
        listOfImages.add(new DbImageModal(R.drawable.img_singlepro));

        adapter=new DbImageAdapter(getContext(),listOfImages);
        binding.viewpager.setAdapter(adapter);

        binding.tablayout.setupWithViewPager(binding.viewpager);

        binding.cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SingleProductPageFragment.this.dismiss();
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onCancel(@NonNull DialogInterface dialog) {
        super.onCancel(dialog);
    }
}