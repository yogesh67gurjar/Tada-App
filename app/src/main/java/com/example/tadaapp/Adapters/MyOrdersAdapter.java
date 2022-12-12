package com.example.tadaapp.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.tadaapp.Fragments.CompletedFragment;
import com.example.tadaapp.Fragments.OngoingFragment;

public class MyOrdersAdapter extends FragmentStateAdapter {

    public String []titles=new String[]{"ongoing","completed"};

    public MyOrdersAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new OngoingFragment();
            case 1:
                return new CompletedFragment();
        }
        return new OngoingFragment();
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
