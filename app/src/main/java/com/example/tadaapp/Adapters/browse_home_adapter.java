package com.example.tadaapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tadaapp.R;

public class browse_home_adapter extends RecyclerView.Adapter<browse_home_adapter.ViewHolder>{

    Context context;

    public browse_home_adapter(Context context, Object o){
        this.context = context;
    }

    @NonNull
    @Override
    public browse_home_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from (parent.getContext ()).inflate (R.layout.db_browse_layout, parent,false);
        browse_home_adapter.ViewHolder viewHolder = new browse_home_adapter.ViewHolder (view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull browse_home_adapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super (itemView);
        }
    }
}
