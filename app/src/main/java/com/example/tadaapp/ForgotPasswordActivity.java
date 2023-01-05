package com.example.tadaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tadaapp.ApiServices.ApiService;
import com.example.tadaapp.Modal.UserForgotPassword;
import com.example.tadaapp.Retrofits.RetrofitServices;
import com.example.tadaapp.databinding.ActivityForgotPasswordBinding;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPasswordActivity extends AppCompatActivity {

    ActivityForgotPasswordBinding binding;
    EditText email_ET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityForgotPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull (getSupportActionBar ()).hide();

        email_ET = findViewById (R.id.email_ET);

        binding.resetpwBtn.setOnClickListener (view -> {
            String Email = email_ET.getText ().toString ();

            if (Email.isEmpty() || Email.contains("@") || Email.contains(".") ) {
                email_ET.setError ("Please Enter Email");
                email_ET.requestFocus ();
            } else {
                userForgotFunc(Email);
            }
        });
    }

    private void userForgotFunc(String email) {
        ApiService apiService= RetrofitServices.getRetrofit().create(ApiService.class);
        Call<UserForgotPassword> call=apiService.forgotUser(email);
        call.enqueue(new Callback<UserForgotPassword>() {
            @Override
            public void onResponse(Call<UserForgotPassword> call, Response<UserForgotPassword> response) {
                assert response.body () != null;
                if(response.isSuccessful ()) {
                    Toast.makeText (getApplicationContext(), "Password Send On Email", Toast.LENGTH_SHORT).show ();
                    Intent i = new Intent (getApplicationContext (), LogInActivity.class);
                    startActivity (i);
                    Log.i("forgot password success",response.body().getMessage());
                    finish();
                }
                else {
                    Toast.makeText(ForgotPasswordActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<UserForgotPassword> call, Throwable t) {
                Toast.makeText(ForgotPasswordActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
