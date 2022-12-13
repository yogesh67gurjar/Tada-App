package com.example.tadaapp.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.tadaapp.Fragments.HomeFragment;
import com.example.tadaapp.Fragments.SeeAllBrowseFragment;
import com.example.tadaapp.Fragments.SeeAllLiveFragment;

import javax.xml.transform.sax.SAXResult;

public class SeeAllVpAdapter extends FragmentStateAdapter {

    private String[] titles=new String[]{"Live Shopping","Browse"};

    public SeeAllVpAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new SeeAllLiveFragment();
            case 1:
                return new SeeAllBrowseFragment();
        }
        return new SeeAllLiveFragment();
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
