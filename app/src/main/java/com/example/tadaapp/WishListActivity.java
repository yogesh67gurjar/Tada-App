package com.example.tadaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.example.tadaapp.Adapters.Wishlist_adapter;

public class WishListActivity extends AppCompatActivity {

    AppCompatButton back_btn;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager LayoutManager;
    Wishlist_adapter adapter;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list);
        getSupportActionBar ().hide ();

        back_btn = findViewById (R.id.back_btn);
        recyclerView = findViewById (R.id.recyclerView);
        LayoutManager = new LinearLayoutManager (getApplicationContext ());
        recyclerView.setLayoutManager (LayoutManager);
        adapter = new Wishlist_adapter (getApplicationContext ());
        recyclerView.setAdapter (adapter);
        recyclerView.setHasFixedSize (true);
        adapter.getItemCount ();
        adapter.notifyDataSetChanged ();

        back_btn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
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
