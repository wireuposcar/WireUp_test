package com.wireupfinland.wireup_test;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateAccount extends AppCompatActivity {


    private EditText fullname;
    private EditText email;
    private EditText password;
    private EditText school;
    private EditText schoolCode;
    private Button createAccountBtn;

    private DatabaseReference mDatabaseReference;
    private FirebaseDatabase mDatabase;
    private FirebaseAuth mAuth;
    private ProgressDialog mProgressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__create_account);

        mDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mDatabase.getReference().child("users");

        mAuth = FirebaseAuth.getInstance();

        mProgressDialog = new ProgressDialog(this);

        fullname = (EditText) findViewById(R.id.fullNameAct);
        email = (EditText) findViewById(R.id.emailAct);
        password = (EditText) findViewById(R.id.passwordAct);
        school = (EditText) findViewById(R.id.schoolAct);
        schoolCode = (EditText) findViewById(R.id.schoolCodeAct);
        createAccountBtn = (Button) findViewById(R.id.createAccountAct);


    }

    public void createNewAccount(View view) {
        String name = fullname.getText().toString().trim();
        String em = email.getText().toString().trim();
        String pwd = password.getText().toString();
        String sch = school.getText().toString().trim();
        final String schCode = schoolCode.getText().toString().trim();

    }
}























