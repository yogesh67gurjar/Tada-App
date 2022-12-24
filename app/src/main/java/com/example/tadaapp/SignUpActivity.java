package com.example.tadaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tadaapp.ApiServices.ApiService;
import com.example.tadaapp.Modal.UserSignUp;
import com.example.tadaapp.Retrofits.RetrofitServices;
import com.example.tadaapp.databinding.ActivitySignUpBinding;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding binding;
    EditText fullname_ET, email_ET, password_ET, confirmpassword_ET;
    TextView LoginTV;
    ApiService apiService;

    private void signupUser(String name,String email,String password,String role)
    {
        apiService= RetrofitServices.getRetrofit().create(ApiService.class);
        Call<UserSignUp> call= apiService.signInUser(name,email,password,binding.user.getText().toString());
        call.enqueue(new Callback<UserSignUp>() {
            @Override
            public void onResponse(Call<UserSignUp> call, Response<UserSignUp> response) {
                if(response.body().getStatus_code()==200)
                {
                    Toast.makeText(getApplicationContext(), "Account Created Successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), DashboardActivity.class);
                    startActivity(i);
                    Log.i("SignUp success message",response.body().getMessage());
                    finish();
                }
                else
                {
                    Toast.makeText(SignUpActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<UserSignUp> call, Throwable t) {
                Toast.makeText(SignUpActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        fullname_ET = findViewById (R.id.fullname_ET);
        email_ET = findViewById (R.id.email_ET);
        password_ET = findViewById (R.id.password_ET);
        confirmpassword_ET = findViewById (R.id.confirmpassword_ET);
        LoginTV = findViewById (R.id.LoginTV);

        TextPaint paint = binding.tadaLogo.getPaint();
        float width = paint.measureText("Tada");
        Shader textShader = new LinearGradient(0, 0, width, binding.tadaLogo.getTextSize(),
                new int[]{
                        Color.parseColor("#FE0187"),
                        Color.parseColor("#FF5A3A"),
                }, null, Shader.TileMode.CLAMP);
        binding.tadaLogo.getPaint().setShader(textShader);

        binding.signupBtn.setOnClickListener(view -> {
            String name = fullname_ET.getText ().toString ();
            String email = email_ET.getText ().toString ();
            String password = password_ET.getText ().toString ();
            String confirm_password = confirmpassword_ET.getText ().toString ();


            if (name.isEmpty()) {
                fullname_ET.setError("Please Enter Your Name");
                fullname_ET.requestFocus();
            } else if (email.isEmpty()) {
                email_ET.setError("Please Enter Email");
                email_ET.requestFocus();
            } else if (password.isEmpty()) {
                password_ET.setError("Enter Your Password");
                password_ET.requestFocus();
            } else if (confirm_password.isEmpty()) {
                confirmpassword_ET.setError("Re-Enter Your Password");
                confirmpassword_ET.requestFocus();
            } else if (!password.equals(confirm_password)) {
                confirmpassword_ET.setError("Passwords Not Matched");
                confirmpassword_ET.requestFocus();
            } else {
                signupUser(name,email,password,binding.user.getText().toString());
            }
        });

        LoginTV.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (getApplicationContext (), LogInActivity.class);
                startActivity (i);
            }
        });
    }
}
