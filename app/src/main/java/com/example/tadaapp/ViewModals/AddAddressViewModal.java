package com.example.tadaapp.ViewModals;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.tadaapp.Modal.AddAddress;
import com.example.tadaapp.Modal.CreditCards;
import com.example.tadaapp.Repository.AddAddressRepo;
import com.example.tadaapp.Repository.CreditCardsRepo;

import java.util.List;

public class AddAddressViewModal extends AndroidViewModel {
    private AddAddressRepo repo;
    private LiveData<List<AddAddress>> allAddresses;


    public AddAddressViewModal(@NonNull Application application) {
        super(application);
        repo=new AddAddressRepo(application);
        allAddresses=repo.getAllAddresses();
    }

    public void insert(AddAddress addAddress)
    {
        repo.insert(addAddress);
    }
    public LiveData<List<AddAddress>> getAllAddresses()
    {
        return allAddresses;
    }
}
