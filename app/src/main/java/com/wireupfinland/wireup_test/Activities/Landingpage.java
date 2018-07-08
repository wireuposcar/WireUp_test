package com.wireupfinland.wireup_test.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wireupfinland.wireup_test.R;

public class Landingpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landingpage);


        Button createAccountBtn = findViewById(R.id.createAccountBtn);
        Button loginBtn = findViewById(R.id.loginBtn);

    }

    public void login(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);

    }
    public void createAccount(View view){
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);
    }
}
