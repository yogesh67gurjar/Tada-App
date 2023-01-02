package com.example.tadaapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tadaapp.R;

public class OnGoing_Adapter extends RecyclerView.Adapter<OnGoing_Adapter.ViewHolder>{

    Context context;

    public OnGoing_Adapter(Context context, Object o){
        this.context = context;
    }

    @NonNull
    @Override
    public OnGoing_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from (parent.getContext ()).inflate (R.layout.my_orders_ongoing_layout, parent,false);
        OnGoing_Adapter.ViewHolder viewHolder = new OnGoing_Adapter.ViewHolder (view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OnGoing_Adapter.ViewHolder holder, int position) {

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
