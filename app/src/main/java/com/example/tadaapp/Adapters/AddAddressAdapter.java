package com.example.tadaapp.Adapters;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tadaapp.Modal.AddAddress;
import com.example.tadaapp.Modal.CreditCards;
import com.example.tadaapp.R;

import java.util.ArrayList;
import java.util.List;

public class AddAddressAdapter extends RecyclerView.Adapter<AddAddressAdapter.AddAddressViewHolder> {

    private List<AddAddress> addAddresses=new ArrayList<>();

    public void setAddAddress(List<AddAddress> addAddress) {
        this.addAddresses = addAddress;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AddAddressAdapter.AddAddressViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.add_new_address_layout,parent,false);
        return new AddAddressAdapter.AddAddressViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddAddressAdapter.AddAddressViewHolder holder, int position) {
        AddAddress currentAddress=addAddresses.get(position);

        String title=currentAddress.getTypeOfAddress();
        holder.titleAdd.setText(title);
        String desc=currentAddress.getApartment() + " , " + currentAddress.getCity() + " , " + currentAddress.getState() +  " , " + currentAddress.getZip();
        holder.descAdd.setText(desc);
      //  holder.defaultBtn.setChecked(Boolean.parseBoolean(currentAddress.getDefaultState()));
    }

    @Override
    public int getItemCount() {
        return addAddresses.size();
    }

    public class AddAddressViewHolder extends RecyclerView.ViewHolder {

        TextView titleAdd;
        TextView descAdd;
        Switch defaultBtn;
        public AddAddressViewHolder(@NonNull View itemView) {
            super(itemView);
            defaultBtn=itemView.findViewById(R.id.defaultBtn);
            titleAdd=itemView.findViewById(R.id.titleAdd);
            descAdd=itemView.findViewById(R.id.descAdd);
        }
    }
}
