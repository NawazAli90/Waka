package com.wakaride.rideshare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.wakaride.rideshare.activities.login;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(this::startActivity,1500);
    }

    private void startActivity() {

        startActivity(new Intent(this, login.class));
        finish();
    }
}
