package com.shahjahan.kiwiuser.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.shahjahan.kiwiuser.R;
import com.shahjahan.kiwiuser.databinding.ActivityLoginBinding;
import com.shahjahan.kiwiuser.dialog.dialog_baseUrl;
import com.shahjahan.kiwiuser.models.Utils;
import com.shahjahan.kiwiuser.models.loginResponse.LoginResponse;
import com.shahjahan.kiwiuser.retrofit.RetrofitAPI;
import com.shahjahan.kiwiuser.retrofit.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity {
    private Button btn1;
    private ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn1=(Button)findViewById(R.id.btnLogin);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(login.this, Maphome.class);
                startActivity(intent);
            }
        });
        TextView txt1 = (TextView)findViewById(R.id.Signup);
        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(login.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });

    }
}
