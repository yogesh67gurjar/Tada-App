package com.example.tadaapp.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.tadaapp.Dao.CreditCardsDao;
import com.example.tadaapp.Database.CreditCardsDatabase;
import com.example.tadaapp.Modal.CreditCards;

import java.util.List;

public class CreditCardsRepo
{
    private CreditCardsDao creditCardsDao;
    private LiveData<List<CreditCards>> allCards;

    public CreditCardsRepo(Application application) {
        CreditCardsDatabase database=CreditCardsDatabase.getInstance(application);
        creditCardsDao=database.creditCardsDao();
        allCards= creditCardsDao.getAllCards();
    }

    public void insert(CreditCards creditCards)
    {
        new InsertCreditCardsAsyncTask(creditCardsDao).execute(creditCards);
    }

    public LiveData<List<CreditCards>> getAllCards()
    {
        return allCards;
    }

    private static class InsertCreditCardsAsyncTask extends AsyncTask<CreditCards,Void,Void>
    {
        private CreditCardsDao creditCardsDao;

        private InsertCreditCardsAsyncTask(CreditCardsDao creditCardsDao)
        {
            this.creditCardsDao=creditCardsDao;
        }

        @Override
        protected Void doInBackground(CreditCards... creditCards) {
            creditCardsDao.insert(creditCards[0]);
            return null;
        }
    }
}
