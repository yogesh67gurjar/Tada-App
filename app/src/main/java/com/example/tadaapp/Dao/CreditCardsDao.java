package com.example.tadaapp.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.tadaapp.Modal.CreditCards;

import java.util.List;


@Dao
public interface CreditCardsDao
{
    @Insert
    void insert(CreditCards creditCards);

    @Query("SELECT * FROM creditcards")
    LiveData<List<CreditCards>> getAllCards();
}