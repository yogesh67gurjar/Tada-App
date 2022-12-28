package com.example.tadaapp.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tadaapp.Adapters.BrowserPopular_Adapter;
import com.example.tadaapp.Adapters.Live_shopping_adapter;
import com.example.tadaapp.R;
import com.example.tadaapp.databinding.FragmentBrowsePopularBinding;
import com.example.tadaapp.databinding.FragmentHomeBinding;


public class BrowsePopularFragment extends Fragment {

    RecyclerView.LayoutManager LayoutManager;
    BrowserPopular_Adapter adapter;
    FragmentBrowsePopularBinding binding;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentBrowsePopularBinding.inflate(inflater,container,false);

//        LayoutManager = new LinearLayoutManager (getActivity (), LinearLayoutManager.HORIZONTAL, false);
        LayoutManager = new GridLayoutManager (getActivity (), 2);
        binding.recyclerView.setLayoutManager (LayoutManager);
        adapter = new BrowserPopular_Adapter (getActivity (), null );
        binding.recyclerView.setAdapter (adapter);
        adapter.notifyDataSetChanged ();
        adapter.getItemCount ();
        binding.recyclerView.setHasFixedSize (true);

        return binding.getRoot();
    }
}