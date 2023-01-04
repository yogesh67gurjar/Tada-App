package com.example.tadaapp.Adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AddAddressAdapter extends RecyclerView.Adapter<AddAddressAdapter.AddAddressViewHolder> {
    @NonNull
    @Override
    public AddAddressAdapter.AddAddressViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AddAddressAdapter.AddAddressViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class AddAddressViewHolder extends RecyclerView.ViewHolder {
        public AddAddressViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
