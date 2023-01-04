package com.example.tadaapp.ViewModals;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.tadaapp.Modal.CreditCards;
import com.example.tadaapp.Repository.CreditCardsRepo;

import java.util.List;

public class CreditCardsViewModal extends AndroidViewModel{
    private CreditCardsRepo repo;
    private LiveData<List<CreditCards>> allCards;

    public CreditCardsViewModal(@NonNull Application application) {
        super(application);
        repo=new CreditCardsRepo(application);
        allCards=repo.getAllCards();
    }

    public void insert(CreditCards creditCards)
    {
        repo.insert(creditCards);
    }
   public LiveData<List<CreditCards>> getAllCards()
    {
        return allCards;
    }

}