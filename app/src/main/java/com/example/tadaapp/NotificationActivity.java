package com.example.tadaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.example.tadaapp.Adapters.Notification_Adapter;

public class NotificationActivity extends AppCompatActivity {

    AppCompatButton back_btn;
    RecyclerView notification_recycler;
    RecyclerView.LayoutManager LayoutManager;
    Notification_Adapter adapter;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        getSupportActionBar().hide();

        back_btn = findViewById (R.id.back_btn);
        notification_recycler = findViewById (R.id.notification_recycler);
        LayoutManager = new LinearLayoutManager (getApplicationContext ());
        notification_recycler.setLayoutManager (LayoutManager);
        adapter = new Notification_Adapter (getApplicationContext ());
        notification_recycler.setAdapter (adapter);
        notification_recycler.setHasFixedSize (true);
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
