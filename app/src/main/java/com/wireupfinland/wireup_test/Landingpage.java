package com.wireupfinland.wireup_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Landingpage extends AppCompatActivity {

    private Button createAccountBtn, loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landingpage);


        createAccountBtn = findViewById(R.id.createAccountBtn);
        loginBtn = findViewById(R.id.loginBtn);

    }
    public void login(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }
    public void createAccount(View view){
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);
        finish();
    }
}
