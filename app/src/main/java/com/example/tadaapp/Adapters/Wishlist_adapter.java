package com.example.tadaapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tadaapp.R;

public class Wishlist_adapter extends RecyclerView.Adapter<Wishlist_adapter.ViewHolder>{

    Context context;

    public Wishlist_adapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public Wishlist_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from (parent.getContext ()).inflate (R.layout.wishlist_layout, parent,false);
        Wishlist_adapter.ViewHolder viewHolder = new Wishlist_adapter.ViewHolder (view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Wishlist_adapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super (itemView);
        }
    }
}
