package com.waka.ride.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PatternMatcher;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.waka.ride.databinding.ActivityRegistrationBinding;
import com.waka.ride.models.RegistrationResponse;
import com.waka.ride.retrofit.RetrofitAPI;
import com.waka.ride.retrofit.RetrofitService;

import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends AppCompatActivity {

    private ActivityRegistrationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
    }

    private void init() {
        binding.btnRegister.setOnClickListener(register -> validateFields());
    }

    private void validateFields() {
        binding.errorMsg.setText("");
        String fullName = binding.inpFullName.getText().toString().trim();
        String email = binding.inpEmail.getText().toString().trim();
        String password = binding.inpPass.getText().toString().trim();
        String phone = binding.inpPhone.getText().toString().trim();

        if(TextUtils.isEmpty(fullName)){
            binding.inpFullName.setError("Field Required");
            binding.inpFullName.setShowSoftInputOnFocus(true);
            binding.inpFullName.setFocusableInTouchMode(true);
            return;
        }
        if(TextUtils.isEmpty(email)){
            binding.inpEmail.setError("Field Required");
            binding.inpEmail.setShowSoftInputOnFocus(true);
            binding.inpEmail.setFocusableInTouchMode(true);
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.inpEmail.setError("Invalid Email Address");
            binding.inpEmail.setShowSoftInputOnFocus(true);
            binding.inpEmail.setFocusableInTouchMode(true);
            return;
        }
        if(TextUtils.isEmpty(password)){
            binding.inpPass.setError("Field Required");
            binding.inpPass.setShowSoftInputOnFocus(true);
            binding.inpPass.setFocusableInTouchMode(true);
            return;
        }
        if(TextUtils.isEmpty(phone)){
            binding.inpPhone.setError("Field Required");
            binding.inpPhone.setShowSoftInputOnFocus(true);
            binding.inpPhone.setFocusableInTouchMode(true);
            return;
        }
        if(phone.length() < 11){
            binding.inpPhone.setError("Invalid phone number");
            binding.inpPhone.setShowSoftInputOnFocus(true);
            binding.inpPhone.setFocusableInTouchMode(true);
            return;
        }
        RetrofitService retrofitService = new RetrofitService(this);
        binding.progressBar.setVisibility(View.VISIBLE);
        new Thread(() -> {
            RetrofitAPI api = retrofitService.createService(RetrofitAPI.class);
            api.registerUser(fullName,email,password,phone).enqueue(new Callback<RegistrationResponse>() {
                @Override
                public void onResponse(Call<RegistrationResponse> call, Response<RegistrationResponse> response) {
                    if(response.isSuccessful()){
                        RegistrationResponse registrationResponse = response.body();
                        if(registrationResponse != null){
                            if(registrationResponse.getSts() == 200){
                                Toast.makeText(RegistrationActivity.this, "Account Registered", Toast.LENGTH_SHORT).show();
                                finish();
                            }else{
                                binding.errorMsg.setText(registrationResponse.getMsg());
                            }
                        }else {
                            binding.errorMsg.setText("Object was null.");
                        }
                    }else {
                        binding.errorMsg.setText("Response was unsuccessful.");
                    }
                    binding.progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onFailure(Call<RegistrationResponse> call, Throwable t) {
                    binding.errorMsg.setText(t.getMessage());
                    binding.progressBar.setVisibility(View.GONE);
                }
            });
        }).start();
    }
}
