package com.example.tadaapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tadaapp.R;
import com.example.tadaapp.ShoppingVideosActivity;

public class BrowserPopular_Adapter extends RecyclerView.Adapter<BrowserPopular_Adapter.ViewHolder>{

    Context context;

    public BrowserPopular_Adapter(Context context, Object o){
        this.context = context;
    }

    @NonNull
    @Override
    public BrowserPopular_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from (parent.getContext ()).inflate (R.layout.db_browse_layout, parent,false);
        BrowserPopular_Adapter.ViewHolder viewHolder = new BrowserPopular_Adapter.ViewHolder (view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BrowserPopular_Adapter.ViewHolder holder, int position) {

        holder.imageView.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent (context, ShoppingVideosActivity.class);
                context.startActivity (i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView ;

        public ViewHolder(@NonNull View itemView) {
            super (itemView);

            imageView = itemView.findViewById (R.id.img);
        }
    }
}
