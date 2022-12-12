package com.example.tadaapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tadaapp.R;

public class Live_shopping_adapter extends RecyclerView.Adapter<Live_shopping_adapter.ViewHolder>{

    Context context;

    public Live_shopping_adapter(Context context, Object o){
        this.context = context;
    }

    @NonNull
    @Override
    public Live_shopping_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from (parent.getContext ()).inflate (R.layout.db_live_layout, parent,false);
        Live_shopping_adapter.ViewHolder viewHolder = new Live_shopping_adapter.ViewHolder (view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Live_shopping_adapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super (itemView);
        }
    }
}
