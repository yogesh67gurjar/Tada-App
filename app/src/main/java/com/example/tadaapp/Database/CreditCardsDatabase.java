package com.example.tadaapp.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.tadaapp.Dao.CreditCardsDao;
import com.example.tadaapp.Modal.CreditCards;

@Database(entities = {CreditCards.class},version=2,exportSchema = false)
public abstract class CreditCardsDatabase extends RoomDatabase {

    private static CreditCardsDatabase instance;
    public abstract CreditCardsDao creditCardsDao();

    public static synchronized CreditCardsDatabase getInstance(Context context)
    {
        if (instance==null)
        {
            instance= Room.databaseBuilder(context.getApplicationContext(),
                            CreditCardsDatabase.class,"credit_card_database")
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
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>
    {
        private CreditCardsDao creditCardsDao;

        private PopulateDbAsyncTask(CreditCardsDatabase db)
        {
            creditCardsDao=db.creditCardsDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            //            creditcardsDao.insert(new CreditCards(0123124124));
            //            we can add creditcards to be already shown by the statement shown above

            return null;
        }
    }
}
