package com.example.tadaapp.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.tadaapp.EditProfileActivity;
import com.example.tadaapp.FollowersActivity;
import com.example.tadaapp.LogInActivity;
import com.example.tadaapp.MyOrdersActivity;
import com.example.tadaapp.PrivacyPolicyActivity;
import com.example.tadaapp.R;
import com.example.tadaapp.SettingsActivity;
import com.example.tadaapp.TermsAndConditionsActivity;
import com.example.tadaapp.WishListActivity;


public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate (R.layout.fragment_profile, container, false);

        TextView my_order_btn = (TextView) view.findViewById (R.id.my_order_btn);
        my_order_btn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity (), MyOrdersActivity.class);
                startActivity (i);
            }
        });

        ImageButton ic_edit=(ImageButton) view.findViewById(R.id.ic_edit);
        ic_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), EditProfileActivity.class));
            }
        });

        TextView terms_and_cond = (TextView) view.findViewById (R.id.terms_btn);
        terms_and_cond.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity (), TermsAndConditionsActivity.class);
                startActivity (i);
            }
        });

        TextView privacy_btn = (TextView) view.findViewById (R.id.privacy_btn);
        privacy_btn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity (), PrivacyPolicyActivity.class);
                startActivity (i);
            }
        });

        TextView  setting_btn = (TextView) view.findViewById (R.id. setting_btn);
        setting_btn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity (), SettingsActivity.class);
                startActivity (i);
            }
        });

        TextView  logout_btn = (TextView) view.findViewById (R.id. logout_btn);
        logout_btn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity (), LogInActivity.class);
                startActivity (i);
            }
        });

        TextView  wishlist_btn = (TextView) view.findViewById (R.id. wishlist_btn);
        wishlist_btn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity (), WishListActivity.class);
                startActivity (i);
            }
        });

        TextView  following_btn = (TextView) view.findViewById (R.id. following_btn);
        following_btn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity (), FollowersActivity.class);
                startActivity (i);
            }
        });


        return view;

    }

}
