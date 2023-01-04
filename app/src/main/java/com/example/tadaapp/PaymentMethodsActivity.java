package com.example.tadaapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.tadaapp.Adapters.AddCardsAdapter;
import com.example.tadaapp.Modal.CreditCards;
import com.example.tadaapp.ViewModals.CreditCardsViewModal;
import com.example.tadaapp.databinding.ActivityPaymentMethodsBinding;

import java.util.List;

public class PaymentMethodsActivity extends AppCompatActivity {

    public static final int ADD_NOTE_REQUEST = 1;
    ActivityPaymentMethodsBinding binding;
    private CreditCardsViewModal creditCardsViewModal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPaymentMethodsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final AddCardsAdapter adapter = new AddCardsAdapter();

        binding.recyclerView.setAdapter(adapter);

        creditCardsViewModal = ViewModelProviders.of(this).get(CreditCardsViewModal.class);
        creditCardsViewModal.getAllCards().observe(this,creditCards -> {
            adapter.setCreditCards(creditCards);
        });


        binding.addcardTv.setOnClickListener(v -> {
            startActivityForResult(new Intent(this, AddNewCardActivity.class), ADD_NOTE_REQUEST);
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_NOTE_REQUEST && resultCode == -1) {

            String cardNumber = data.getStringExtra(AddNewCardActivity.EXTRA_CARDNUMBER);
            CreditCards creditCards = new CreditCards(cardNumber);
            creditCardsViewModal.insert(creditCards);

            Toast.makeText(this, "New Card Added", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Card Not Saved", Toast.LENGTH_SHORT).show();
        }
    }
}