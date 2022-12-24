package com.example.tadaapp.ApiServices;

import com.example.tadaapp.Modal.UserLogin;
import com.example.tadaapp.Modal.UserSignUp;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("user-login")
    Call<UserLogin> loginUser(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("user-registration")
    Call<UserSignUp> signInUser(
            @Field("user_name") String user_name
            , @Field("user_email") String user_email
            , @Field("user_password") String user_password
            , @Field("role") String role);
}
