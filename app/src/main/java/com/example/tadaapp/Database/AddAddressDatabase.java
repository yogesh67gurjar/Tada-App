package com.example.tadaapp.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.tadaapp.Dao.AddAddressDao;
import com.example.tadaapp.Dao.CreditCardsDao;
import com.example.tadaapp.Modal.AddAddress;

@Database(entities = {AddAddress.class},version=1,exportSchema = false)
public abstract class AddAddressDatabase extends RoomDatabase {

    private static AddAddressDatabase instance;
    public abstract AddAddressDao addAddressDao();

    public static synchronized AddAddressDatabase getInstance(Context context)
    {
        if (instance==null)
        {
            instance= Room.databaseBuilder(context.getApplicationContext(),
                            AddAddressDatabase.class,"add_address_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback=new RoomDatabase.Callback()
    {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new AddAddressDatabase.PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>
    {
        private AddAddressDao addAddressDao;

        private PopulateDbAsyncTask(AddAddressDatabase db)
        {
            addAddressDao=db.addAddressDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            //            addAddressDao.insert(new AddAddress(0123124124));
            //            we can add addresses to be already shown by the statement shown above

            return null;
        }
    }
}
