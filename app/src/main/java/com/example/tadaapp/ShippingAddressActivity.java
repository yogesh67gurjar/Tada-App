package com.example.tadaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.tadaapp.Adapters.AddAddressAdapter;
import com.example.tadaapp.Adapters.AddCardsAdapter;
import com.example.tadaapp.Fragments.AddNewAddressFragment;
import com.example.tadaapp.ViewModals.AddAddressViewModal;
import com.example.tadaapp.ViewModals.CreditCardsViewModal;
import com.example.tadaapp.databinding.ActivityPaymentMethodsBinding;
import com.example.tadaapp.databinding.ActivityShippingAddressBinding;

public class ShippingAddressActivity extends AppCompatActivity {

    ActivityShippingAddressBinding binding;
    public static final int ADD_ADDRESS_REQUEST = 1;
    private AddAddressViewModal addAddressViewModal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityShippingAddressBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final AddAddressAdapter adapter = new AddAddressAdapter();

        binding.recyclerView.setAdapter(adapter);

        binding.addaddressTv.setOnClickListener(view -> {
            AddNewAddressFragment obj=new AddNewAddressFragment();
            obj.show(getSupportFragmentManager(),obj.getTag());
        });
    }
}