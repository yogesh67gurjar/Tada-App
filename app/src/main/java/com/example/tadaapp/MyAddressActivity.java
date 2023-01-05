package com.example.tadaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.tadaapp.Adapters.AddAddressAdapter;
import com.example.tadaapp.Modal.AddAddress;
import com.example.tadaapp.ViewModals.AddAddressViewModal;
import com.example.tadaapp.databinding.ActivityMyAddressBinding;

import java.util.List;

public class MyAddressActivity extends AppCompatActivity {

    ActivityMyAddressBinding binding;
    public static final int ADD_ADDRESS_REQUEST = 1;
    private AddAddressViewModal addAddressViewModal;
    private static final String TAG = "MyAddressActivity";
    final AddAddressAdapter adapter = new AddAddressAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyAddressBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        binding.recyclerView.setAdapter(adapter);

        addAddressViewModal = ViewModelProviders.of(this).get(AddAddressViewModal.class);
        addAddressViewModal.getAllAddresses().observe(this, new Observer<List<AddAddress>>() {
            @Override
            public void onChanged(List<AddAddress> addAddresses) {
                adapter.setAddAddress(addAddresses);
            }
        });

        binding.addaddressTv.setOnClickListener(view -> {
            startActivityForResult(new Intent(this, AddNewAddressActivity.class), ADD_ADDRESS_REQUEST);
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_ADDRESS_REQUEST && resultCode == -1) {

            String fname = data.getStringExtra(AddNewAddressActivity.EXTRA_FNAME);
            String lname = data.getStringExtra(AddNewAddressActivity.EXTRA_LNAME);
            String city = data.getStringExtra(AddNewAddressActivity.EXTRA_CITY);
            String apartment = data.getStringExtra(AddNewAddressActivity.EXTRA_APARTMENT);
            String state = data.getStringExtra(AddNewAddressActivity.EXTRA_STATE);
            String country = data.getStringExtra(AddNewAddressActivity.EXTRA_COUNTRY);
            String phone = data.getStringExtra(AddNewAddressActivity.EXTRA_PHONE);
            String typeOfAddress = data.getStringExtra(AddNewAddressActivity.EXTRA_TYPEOFADDRESS);
            String zip = data.getStringExtra(AddNewAddressActivity.EXTRA_ZIP);
            String defaultState = data.getStringExtra(AddNewAddressActivity.EXTRA_DEFAULTSTATE);


            AddAddress addAddress = new AddAddress(fname,lname,apartment,city,state,country,zip,phone,defaultState,typeOfAddress);
            addAddressViewModal.insert(addAddress);

            Toast.makeText(this, "New Card Added", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Card Not Saved", Toast.LENGTH_SHORT).show();
        }
    }
}