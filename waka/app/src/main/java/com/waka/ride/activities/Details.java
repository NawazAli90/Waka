package com.waka.ride.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.waka.ride.Common.callbacks.OnLoginApiResponse;
import com.waka.ride.Common.repo.SignupRepository;
import com.waka.ride.Core.network.constant.response.UserDTO;
import com.waka.ride.R;

import org.jetbrains.annotations.NotNull;

public class Details extends AppCompatActivity {
    private EditText firstName,lastName, id,email,password;
    private String  phoneNumber;
    private Button btn1;
    private  OnLoginApiResponse onLoginApiResponse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        btn1 =(Button)findViewById(R.id.button3);
        firstName =(EditText)findViewById(R.id.signupFirstName);
        lastName =(EditText)findViewById(R.id.signupLastName);
        id =(EditText)findViewById(R.id.signupId);
        email =(EditText)findViewById(R.id.signupEmail);
        password =(EditText)findViewById(R.id.signupPass);

         onLoginApiResponse = new OnLoginApiResponse() {
            @Override
            public void onResponse(@NotNull UserDTO model) {
                Toast.makeText(getApplicationContext(), model.getUser_email(), Toast.LENGTH_LONG).show();

                routeActivity();
            }

            @Override
            public void onFailure(@NotNull String message) {

            }
        };

        phoneNumber = getIntent().getExtras().getString("phoneNumber");
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup();
            }
        });

    }


    private void signup(){
        SignupRepository repo = new SignupRepository();

        String fullname = firstName.getText().toString() + lastName.getText().toString() ;
        String password = this.password.getText().toString();
        String id = this.id.getText().toString();
        String email = this.email.getText().toString();

        repo.signup(id,password,phoneNumber,email,fullname,onLoginApiResponse);
    }
    private void routeActivity(){
        Intent intent=new Intent(Details.this, login.class);
        startActivity(intent);
    }
}