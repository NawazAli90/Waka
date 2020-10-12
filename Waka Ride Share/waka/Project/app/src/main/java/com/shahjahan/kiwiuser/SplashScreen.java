package com.waka.ride;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.waka.ride.activities.Dashboard;
import com.waka.ride.activities.login;
import com.waka.ride.models.Utils;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(this::startActivity,3000);
    }

    private void startActivity() {
        if(Utils.isLogin(this)){
            startActivity(new Intent(this,Dashboard.class));
        }else {
            startActivity(new Intent(this, login.class));
        }
        finish();
    }
}
