package com.example.tadaapp.Fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.tadaapp.Adapters.Category_Adapter;
import com.example.tadaapp.Adapters.DbImageSliderAdapter;
import com.example.tadaapp.Adapters.Live_shopping_adapter;
import com.example.tadaapp.Adapters.New_Item_Adapter;
import com.example.tadaapp.Adapters.Notification_Adapter;
import com.example.tadaapp.Adapters.browse_home_adapter;
import com.example.tadaapp.FollowersActivity;
import com.example.tadaapp.Modal.ImageModel;
import com.example.tadaapp.NotificationActivity;
import com.example.tadaapp.R;
import com.example.tadaapp.SeeAllActivity;
import com.example.tadaapp.TermsAndConditionsActivity;
import com.example.tadaapp.databinding.FragmentHomeBinding;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    private ViewPager screenPager;
    DbImageSliderAdapter dbImageSliderAdapter;
    int position = 0;
//    RecyclerView firstRecyclerVIew;
    RecyclerView.LayoutManager LayoutManager, LayoutManager2, LayoutManager3, LayoutManager4;
    Live_shopping_adapter adapter;
    browse_home_adapter adapter2;
    Category_Adapter adapter3;
    New_Item_Adapter adapter4;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater,container,false);
//        View view = inflater.inflate (R.layout.fragment_profile, container, false);

        TextPaint paint = binding.basTV.getPaint();
        float width = paint.measureText("Become a seller");

        Shader textShader = new LinearGradient(0, 0, width, binding.basTV.getTextSize(),
                new int[]{
                        Color.parseColor("#FE0187"),
                        Color.parseColor("#FF5A3A"),
                }, null, Shader.TileMode.CLAMP);
        binding.basTV.getPaint().setShader(textShader);

        paint = binding.tadaTV.getPaint();
        width = paint.measureText("Tada");
        textShader = new LinearGradient(0, 0, width, binding.tadaTV.getTextSize(),
                new int[]{
                        Color.parseColor("#FE0187"),
                        Color.parseColor("#FF5A3A"),
                }, null, Shader.TileMode.CLAMP);
        binding.tadaTV.getPaint().setShader(textShader);


        List<ImageModel> sList = new ArrayList<>();
        sList.add(new ImageModel(R.drawable.db_slider_img1));
        sList.add(new ImageModel(R.drawable.db_slider_img1));
        sList.add(new ImageModel(R.drawable.db_slider_img1));

        // setup ViewPager

        dbImageSliderAdapter = new DbImageSliderAdapter(getContext(), sList);
        binding.viewPager.setAdapter(dbImageSliderAdapter);

        //setup tabLayout with ViewPager
        binding.tabIndicator.setupWithViewPager(binding.viewPager);

        binding.tabIndicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == sList.size()) {
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        binding.notificationBtn.setOnClickListener (view ->{
            Intent i = new Intent(getActivity (), NotificationActivity.class);
            startActivity (i);
        });

        binding.btnSeeAll.setOnClickListener (View ->{
            Intent i = new Intent(getActivity (), SeeAllActivity.class);
            startActivity (i);
        });

        binding.btnSeeAll2.setOnClickListener (View ->{
            Intent i = new Intent(getActivity (), SeeAllActivity.class);
            startActivity (i);
        });

        binding.txtSeeAll.setOnClickListener (View ->{
            Intent i = new Intent(getActivity (), SeeAllActivity.class);
            startActivity (i);
        });

        binding.txtSeeAll2.setOnClickListener (View ->{
            Intent i = new Intent(getActivity (), SeeAllActivity.class);
            startActivity (i);
        });

        LayoutManager = new LinearLayoutManager(getActivity (), LinearLayoutManager.HORIZONTAL, false);
        binding.firstRecyclerVIew.setLayoutManager (LayoutManager);

        LayoutManager2 = new LinearLayoutManager(getActivity (), LinearLayoutManager.HORIZONTAL, false);
        binding.secondRecyclerVIew.setLayoutManager (LayoutManager2);

        LayoutManager3 = new LinearLayoutManager(getActivity (), LinearLayoutManager.HORIZONTAL, false);
        binding.thirdRecyclerVIew.setLayoutManager (LayoutManager3);

        LayoutManager4 = new LinearLayoutManager(getActivity (), LinearLayoutManager.HORIZONTAL, false);
        binding.fourRecyclerVIew.setLayoutManager (LayoutManager4);

        adapter = new Live_shopping_adapter (getActivity (), null );
        adapter2 = new browse_home_adapter (getActivity (), null);
        adapter3 = new Category_Adapter (getActivity (), null);
        adapter4 = new New_Item_Adapter (getActivity (), null);

        binding.firstRecyclerVIew.setAdapter (adapter);
        binding.secondRecyclerVIew.setAdapter (adapter2);
        binding.thirdRecyclerVIew.setAdapter (adapter3);
        binding.fourRecyclerVIew.setAdapter (adapter4);

        adapter.notifyDataSetChanged ();
        adapter2.notifyDataSetChanged ();
        adapter3.notifyDataSetChanged ();
        adapter4.notifyDataSetChanged ();

        adapter.getItemCount ();
        adapter2.getItemCount ();
        adapter3.getItemCount ();
        adapter4.getItemCount ();

        binding.firstRecyclerVIew.setHasFixedSize (true);
        binding.secondRecyclerVIew.setHasFixedSize (true);
        binding.thirdRecyclerVIew.setHasFixedSize (true);
        binding.fourRecyclerVIew.setHasFixedSize (true);

        return binding.getRoot();
    }
}
