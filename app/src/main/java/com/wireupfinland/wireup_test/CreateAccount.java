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


        createAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewAccount();
            }
        });


    }

    public void createNewAccount() {
        final String name = fullname.getText().toString().trim();
        final String em = email.getText().toString().trim();
        final String pwd = password.getText().toString();
        final String sch = school.getText().toString().trim();
        final String schCode = schoolCode.getText().toString().trim();

        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(em) && !TextUtils.isEmpty(pwd) && !TextUtils.isEmpty(sch) && !TextUtils.isEmpty(schCode)) {
            mProgressDialog.setMessage("Creating account....");
            mProgressDialog.show();

            mAuth.createUserWithEmailAndPassword(em, pwd)
                    .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            if (authResult != null) {

                                String userid = mAuth.getCurrentUser().getUid();
                                DatabaseReference currentUserDb = mDatabaseReference.child(userid);
                                currentUserDb.child("firstName").setValue(name);
                                currentUserDb.child("email").setValue(em);
                                currentUserDb.child("schoolCode").setValue(schCode);
                                currentUserDb.child("schoolName").setValue(sch);

                                mProgressDialog.dismiss();

                                //log in users

                                Intent intent = new Intent(CreateAccount.this, Main.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);


                            }
                        }
                    });
        }

    }
}























