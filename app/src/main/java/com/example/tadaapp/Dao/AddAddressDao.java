package com.example.tadaapp.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.tadaapp.Modal.AddAddress;

import java.util.List;

@Dao
public interface AddAddressDao {
    @Insert
    void insert(AddAddress addAddress);

    @Query("SELECT * FROM addaddress")
    LiveData<List<AddAddress>> getAlladdresses();
}
