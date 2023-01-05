package com.example.tadaapp.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tadaapp.Adapters.CompleteOrder_Adapter;
import com.example.tadaapp.Adapters.OnGoing_Adapter;
import com.example.tadaapp.R;
import com.example.tadaapp.databinding.FragmentCompletedBinding;
import com.example.tadaapp.databinding.FragmentOngoingBinding;

public class CompletedFragment extends Fragment {

    FragmentCompletedBinding binding;
    RecyclerView.LayoutManager LayoutManager;
    CompleteOrder_Adapter adapter;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCompletedBinding.inflate(inflater,container,false);

        LayoutManager = new LinearLayoutManager (getActivity (), LinearLayoutManager.VERTICAL, false);
        binding.recyclerView.setLayoutManager (LayoutManager);

        adapter = new CompleteOrder_Adapter (getActivity (), null );
        binding.recyclerView.setAdapter (adapter);
        adapter.notifyDataSetChanged ();
        adapter.getItemCount ();
        binding.recyclerView.setHasFixedSize (true);

        return binding.getRoot();
    }
}