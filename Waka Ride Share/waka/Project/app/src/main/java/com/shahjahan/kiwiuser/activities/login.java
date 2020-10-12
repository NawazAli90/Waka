package com.waka.ride.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.waka.ride.databinding.ActivityLoginBinding;
import com.waka.ride.dialog.dialog_baseUrl;
import com.waka.ride.models.Utils;
import com.waka.ride.models.loginResponse.LoginResponse;
import com.waka.ride.retrofit.RetrofitAPI;
import com.waka.ride.retrofit.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity {

    private ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
    }

    private void init() {
        /*binding.btnBaseURL.setOnClickListener(baseUrl ->
                Utils.startDialog(getSupportFragmentManager(), dialog_baseUrl.newInstance()));*/
        binding.btnLogin.setOnClickListener(login -> {
            validateFields();
            /*if(Utils.getBaseURL(this) != null){
                validateFields();
            }else {
                openDialog();
            }*/
        });
        binding.btnRegister.setOnClickListener(register -> startActivity(new Intent(this,RegistrationActivity.class)));
        binding.btnForgotPassword.setOnClickListener(forgot -> startActivity(new Intent(this,ForgotPasswordActivity.class)));
    }

    private void openDialog(){
        new AlertDialog.Builder(this)
                .setTitle("No Base URL")
                .setMessage("No base url found.Set one?")
                .setPositiveButton("ok",((dialog, which) ->
                        Utils.startDialog(getSupportFragmentManager(), dialog_baseUrl.newInstance())))
                .setNegativeButton("Cancel",((dialog, which) -> dialog.dismiss())).show();
    }

    private void validateFields() {
        binding.errorMsg.setText("");
        String email = binding.inpEmail.getText().toString().trim();
        String password = binding.inpPassword.getText().toString().trim();
        if (email.isEmpty()) {
            binding.inpEmail.setError("Field Required");
            binding.inpEmail.setShowSoftInputOnFocus(true);
            binding.inpEmail.setFocusableInTouchMode(true);
            return;
        }
        if (password.isEmpty()) {
            binding.inpPassword.setError("Field Required");
            binding.inpPassword.setShowSoftInputOnFocus(true);
            binding.inpPassword.setFocusableInTouchMode(true);
            return;
        }
        binding.progressBar.setVisibility(View.VISIBLE);
        new Thread(() -> {
            RetrofitService retrofitService = new RetrofitService(login.this);
            RetrofitAPI api = retrofitService.createService(RetrofitAPI.class);
            api.loginResponse(email,password).enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    if(response.isSuccessful()){
                        LoginResponse loginResponses = response.body();
                        if(loginResponses != null){
                            if(loginResponses.getSts() == 200){
                                Utils.setLogin(login.this,true);
                                Utils.setUser(login.this,loginResponses.getDetails());
                                startActivity(new Intent(login.this,Dashboard.class));
                                finish();
                            }
                            else {
                                binding.errorMsg.setText("Invalid Login Details. May be not Organization Account");
                            }
                        }
                    }else {
                        binding.errorMsg.setText("Response failed.Check URL or internet");
                    }
                    binding.progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    binding.errorMsg.setText(t.getMessage());
                    binding.progressBar.setVisibility(View.GONE);
                }
            });
        }).start();
    }
}
