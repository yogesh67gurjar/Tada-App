package com.example.tadaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tadaapp.Adapters.MyOrdersAdapter;
import com.example.tadaapp.databinding.ActivityMyOrdersBinding;
import com.google.android.material.tabs.TabLayoutMediator;

public class MyOrdersActivity extends AppCompatActivity {

    ActivityMyOrdersBinding binding;
    AppCompatButton back_btn;
    MyOrdersAdapter adapter;
    public String[] titles = new String[]{"ongoing", "completed"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        binding = ActivityMyOrdersBinding.inflate (getLayoutInflater ());
        setContentView (binding.getRoot ());
        getSupportActionBar ().hide ();

        back_btn = findViewById (R.id.back_btn);
        adapter = new MyOrdersAdapter (this);
        binding.viewpager.setAdapter (adapter);

        new TabLayoutMediator (binding.tablayout, binding.viewpager, ((tab, position) -> tab.setText (titles[position]))).attach ();

        back_btn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent (MyOrdersActivity.this, DashboardActivity.class);
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
