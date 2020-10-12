package com.waka.ride.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.waka.ride.R;

public class PslTsl extends AppCompatActivity {
    private Button alertbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psl_tsl);
        alertbtn =(Button)findViewById(R.id.button8);
        alertbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(PslTsl.this);
                builder.setCancelable(true);
                builder.setMessage("Saved Successfully");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(PslTsl.this, Documents.class);
                        startActivity(intent);
                    }
                });
                builder.show();
            }
        });
    }
}