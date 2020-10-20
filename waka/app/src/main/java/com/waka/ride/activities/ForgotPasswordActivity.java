package com.waka.ride.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.waka.ride.databinding.ActivityForgotPasswordBinding;
import com.waka.ride.models.ForgotPassword;
import com.waka.ride.retrofit.RetrofitAPI;
import com.waka.ride.retrofit.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPasswordActivity extends AppCompatActivity {

    private ActivityForgotPasswordBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForgotPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbar.setNavigationOnClickListener(nac -> finish());

        binding.btnCheckAccount.setOnClickListener(checkAccount -> validateField());
    }

    private void validateField() {
    }
}
