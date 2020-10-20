package com.waka.ride.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.waka.ride.R;

public class Signupform extends AppCompatActivity {
    String phoneNumber = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupform);
        Button btn1 = (Button)findViewById(R.id.button2);
        phoneNumber = getIntent().getExtras().getString("phoneNumber");
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Signupform.this, Details.class);
                intent.putExtra("phoneNumber",phoneNumber);
                startActivity(intent);
            }
        });
    }
}