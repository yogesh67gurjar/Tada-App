package com.example.tadaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.tadaapp.databinding.ActivityAddNewCardBinding;

public class AddNewCardActivity extends AppCompatActivity {

    ActivityAddNewCardBinding binding;

    public static final int REQUEST_CODE=1000;

    public static final String EXTRA_CARDNUMBER="com.example.tadaseller.EXTRA_CARDNUMBER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddNewCardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        binding.backBtn.setOnClickListener(v -> {
            Toast.makeText(this, "Card Not Saved", Toast.LENGTH_SHORT).show();
            finish();
        });

        binding.addBtn.setOnClickListener(v -> {
            saveCard();
        });
    }

    private void saveCard()
    {
        String name =binding.nameOnCard.getText().toString();
        String number=binding.cardNumber.getText().toString();
        String expiry=binding.expiryDate.getText().toString();
        String cvv=binding.cvv.getText().toString();

        if (binding.nameOnCard.getText().toString().isEmpty()) {
            binding.nameOnCard.setError ("Please Enter Name");
            binding.nameOnCard.requestFocus ();
        }
        else if (binding.cardNumber.getText().toString().isEmpty()) {
            binding.cardNumber.setError ("Please Enter Card Number");
            binding.cardNumber.requestFocus ();
        }
        else if (binding.expiryDate.getText().toString().isEmpty()) {
            binding.expiryDate.setError ("Please Enter Expiry Date");
            binding.expiryDate.requestFocus ();
        }
        else if (binding.cvv.getText().toString().isEmpty()) {
            binding.cvv.setError ("Please Enter Cvv");
            binding.cvv.requestFocus ();
        }

        else {
            Intent data=new Intent();
            data.putExtra(name,name);
            data.putExtra(number,number);
            data.putExtra(expiry,expiry);
            data.putExtra(cvv,cvv);

            setResult(RESULT_OK,data);
            finish();
        }
    }
}