package com.example.tadaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tadaapp.Fragments.HomeFragment;
import com.example.tadaapp.Fragments.ProfileFragment;

public class TermsAndConditionsActivity extends AppCompatActivity {

    AppCompatButton back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_terms_and_conditions);
        getSupportActionBar ().hide ();

        back_btn = findViewById (R.id.back_btn);

        back_btn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent (TermsAndConditionsActivity.this, DashboardActivity.class);
//                startActivity (i);
                onBackPressed ();
            }
        });
    }
    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() == 0) {
            this.finish();
        } else {
            super.onBackPressed(); //replaced
        }
    }
}
