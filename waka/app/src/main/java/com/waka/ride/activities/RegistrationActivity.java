package com.waka.ride.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.waka.ride.R;

public class RegistrationActivity extends AppCompatActivity {

    EditText _phoneTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Button btn1 =(Button)findViewById(R.id.inp_email);
        _phoneTV = (EditText) findViewById(R.id.phone);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RegistrationActivity.this, Signupform.class);
                intent.putExtra("phoneNumber",_phoneTV.getText().toString());
                startActivity(intent);
            }
        });
    }
}