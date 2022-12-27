package com.example.tadaapp.Adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LiveProductsAdapter extends RecyclerView.Adapter<LiveProductsAdapter.LiveProductsViewHolder>
{

    @NonNull
    @Override
    public LiveProductsAdapter.LiveProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull LiveProductsAdapter.LiveProductsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class LiveProductsViewHolder extends RecyclerView.ViewHolder {
        public LiveProductsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
