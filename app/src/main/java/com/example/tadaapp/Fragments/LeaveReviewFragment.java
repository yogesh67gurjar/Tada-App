package com.example.tadaapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tadaapp.databinding.FragmentLeaveReviewBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class LeaveReviewFragment extends BottomSheetDialogFragment {
    FragmentLeaveReviewBinding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLeaveReviewBinding.inflate(inflater,container,false);



        return binding.getRoot();
    }
}