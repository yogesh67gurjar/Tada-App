package com.example.tadaapp.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.tadaapp.Fragments.SeeAllBrowseFragment;
import com.example.tadaapp.Fragments.SeeAllLiveFragment;
import com.example.tadaapp.Fragments.SellerProfileStoreFragment;
import com.example.tadaapp.Fragments.SellerProfileVideoFragment;

public class SellerProfileVpAdapter extends FragmentStateAdapter {

    private String[] titles=new String[]{"Video","Store"};

    public SellerProfileVpAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new SellerProfileVideoFragment();
            case 1:
                return new SellerProfileStoreFragment();
        }
        return new SellerProfileVideoFragment();
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
