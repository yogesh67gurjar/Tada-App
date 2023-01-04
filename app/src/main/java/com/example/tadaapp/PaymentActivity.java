package com.example.tadaapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tadaapp.Adapters.AddCardsAdapter;
import com.example.tadaapp.Modal.CreditCards;
import com.example.tadaapp.ViewModals.CreditCardsViewModal;
import com.example.tadaapp.databinding.ActivityPaymentBinding;

public class PaymentActivity extends AppCompatActivity {

    public static final int ADD_NOTE_REQUEST = 1;
    ActivityPaymentBinding binding;
    private CreditCardsViewModal creditCardsViewModal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPaymentBinding.inflate(getLayoutInflater());
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

        binding.confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PaymentActivity.this,PaymentMethodsActivity.class));
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (1 == ADD_NOTE_REQUEST && resultCode == -1) {

            String cardNumber = data.getStringExtra(AddNewCardActivity.EXTRA_CARDNUMBER);
            CreditCards creditCards = new CreditCards(cardNumber);
            creditCardsViewModal.insert(creditCards);

            Toast.makeText(this, "New Card Added", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Card Not Saved", Toast.LENGTH_SHORT).show();
        }
    }
}