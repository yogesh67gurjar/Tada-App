package com.example.tadaapp.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.tadaapp.Dao.AddAddressDao;
import com.example.tadaapp.Dao.CreditCardsDao;
import com.example.tadaapp.Database.AddAddressDatabase;
import com.example.tadaapp.Database.CreditCardsDatabase;
import com.example.tadaapp.Modal.AddAddress;
import com.example.tadaapp.Modal.CreditCards;

import java.util.List;

public class AddAddressRepo {

    private AddAddressDao addAddressDao;
    private LiveData<List<AddAddress>> allAddresses;

    public AddAddressRepo(Application application) {
        AddAddressDatabase database=AddAddressDatabase.getInstance(application);
        addAddressDao=database.addAddressDao();
        allAddresses= addAddressDao.getAlladdresses();
    }

    public void insert(AddAddress addAddress)
    {
        new InsertAddressAsyncTask(addAddressDao).execute(addAddress);
    }

    public LiveData<List<AddAddress>> getAllAddresses()
    {
        return allAddresses;
    }

    private static class InsertAddressAsyncTask extends AsyncTask<AddAddress,Void,Void>
    {
        private AddAddressDao addAddressDao;

        private InsertAddressAsyncTask(AddAddressDao addAddressDao)
        {
            this.addAddressDao=addAddressDao;
        }

        @Override
        protected Void doInBackground(AddAddress... addAddress) {
            addAddressDao.insert(addAddress[0]);
            return null;
        }
    }

}
