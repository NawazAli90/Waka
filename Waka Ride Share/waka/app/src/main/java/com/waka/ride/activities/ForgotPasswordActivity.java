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
        String email = binding.inpEmail.getText().toString().trim();
        if(TextUtils.isEmpty(email)){
            binding.inpEmail.setError("Field Required");
            binding.inpEmail.setShowSoftInputOnFocus(true);
            binding.inpEmail.setFocusableInTouchMode(true);
            return;
        }
        RetrofitService retrofitService = new RetrofitService(this);
        RetrofitAPI api = retrofitService.createService(RetrofitAPI.class);
        binding.progressBar.setVisibility(View.VISIBLE);
        new Thread(() -> {
            api.resetPassword(email).enqueue(new Callback<ForgotPassword>() {
                @Override
                public void onResponse(Call<ForgotPassword> call, Response<ForgotPassword> response) {
                    binding.progressBar.setVisibility(View.GONE);
                    if(response.isSuccessful()){
                        ForgotPassword forgotPassword = response.body();
                        if(forgotPassword != null){
                            new AlertDialog.Builder(ForgotPasswordActivity.this)
                                    .setTitle("Response")
                                    .setMessage(forgotPassword.getMsg())
                                    .setCancelable(false)
                                    .setPositiveButton("OK",((dialog, which) -> dialog.dismiss())).show();
                        }else {
                            new AlertDialog.Builder(ForgotPasswordActivity.this)
                                    .setTitle("Empty Response")
                                    .setMessage("Response is empty")
                                    .setCancelable(false)
                                    .setPositiveButton("OK",((dialog, which) -> dialog.dismiss())).show();
                        }
                    }else {
                        new AlertDialog.Builder(ForgotPasswordActivity.this)
                                .setTitle("Response Unsuccessful")
                                .setMessage("Response was unsuccessful.")
                                .setCancelable(false)
                                .setPositiveButton("OK",((dialog, which) -> dialog.dismiss())).show();
                    }

                }

                @Override
                public void onFailure(Call<ForgotPassword> call, Throwable t) {
                    binding.progressBar.setVisibility(View.GONE);
                    new AlertDialog.Builder(ForgotPasswordActivity.this)
                            .setTitle("Response Failed")
                            .setMessage("Response was unsuccessful.")
                            .setCancelable(false)
                            .setPositiveButton("OK",((dialog, which) -> dialog.dismiss())).show();
                }
            });
        }).start();
    }
}
