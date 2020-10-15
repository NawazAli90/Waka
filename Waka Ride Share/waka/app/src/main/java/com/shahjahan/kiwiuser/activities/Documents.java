package com.shahjahan.kiwiuser.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.shahjahan.kiwiuser.R;

public class Documents extends AppCompatActivity {
    private TextView txt1,txt2,txt3,arw1,arw2,arw3;
    private Button alertbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documents);
        txt2 =(TextView)findViewById(R.id.textView15);
        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Documents.this, PslTsl.class);
                startActivity(intent);
            }
        });
        txt1 = (TextView)findViewById(R.id.textView13);
        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Documents.this, Licensedoc.class);
                startActivity(intent);
            }
        });
        txt3 =(TextView)findViewById(R.id.textView16);
        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Documents.this, PLisence.class);
                startActivity(intent);
            }
        });
        arw1 =(TextView)findViewById(R.id.textView18);
        arw1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Documents.this, Licensedoc.class);
                startActivity(intent);
            }
        });
        arw2 =(TextView)findViewById(R.id.textView20);
        arw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Documents.this, PslTsl.class);
                startActivity(intent);
            }
        });
        arw3 =(TextView)findViewById(R.id.textView21);
        arw3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Documents.this, PslTsl.class);
                startActivity(intent);
            }
        });

    }
}