package com.shahjahan.kiwiuser.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.shahjahan.kiwiuser.R;

public class Details extends AppCompatActivity {
    private TextView txt1;
    private Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        btn1 =(Button)findViewById(R.id.button3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Details.this, Documents.class);
                startActivity(intent);
            }
        });
        txt1 = (TextView)findViewById(R.id.textView11);
        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Details.this, login.class);
                startActivity(intent);
            }
        });
    }
}