package com.shahjahan.kiwiuser.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.shahjahan.kiwiuser.R;
import com.shahjahan.kiwiuser.databinding.ActivityRegistrationBinding;
import com.shahjahan.kiwiuser.models.RegistrationResponse;
import com.shahjahan.kiwiuser.retrofit.RetrofitAPI;
import com.shahjahan.kiwiuser.retrofit.RetrofitService;

import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Button btn1 =(Button)findViewById(R.id.inp_email);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RegistrationActivity.this, Signupform.class);
                startActivity(intent);
            }
        });
    }
}