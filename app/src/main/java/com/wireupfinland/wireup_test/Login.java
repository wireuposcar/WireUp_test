package com.wireupfinland.wireup_test;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static final String TAG = "Login";

    private EditText email;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        email = (EditText) findViewById(R.id.emailEd);
        password = (EditText) findViewById(R.id.passwordEd);
        login = (Button) findViewById(R.id.loginBtn);


        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        //databaseReference.addValueEventListener(new ValueEventListener() {
          //  @Override
            //public void onDataChange(DataSnapshot dataSnapshot) {
              //  String value = dataSnapshot.getValue(String.class);
                //Toast.makeText(Login.this, value, Toast.LENGTH_SHORT).show();
            //}

            //@Override
            //public void onCancelled(DatabaseError databaseError) {

            //}
        //});

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user != null) {
                    //user is signed in
                    Log.d(TAG, "user signed in");
                } else {
                    //user is not signed in
                    Log.d(TAG, "user signed out");
                }
            }
        };

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailString = email.getText().toString();
                String pwd = password.getText().toString();

                if (!emailString.equals("") && !pwd.equals("")) {
                    mAuth.signInWithEmailAndPassword(emailString, pwd)
                            .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (!task.isSuccessful()) {
                                        Toast.makeText(Login.this, "Faild to sign in", Toast.LENGTH_LONG)
                                                .show();
                                    } else {
                                        Toast.makeText(Login.this, "Signed in", Toast.LENGTH_LONG)
                                                .show();
                                        finish();

                                    }
                                }
                            });
                }
            }
        });

    }
    public void startMainActivity() {
        Intent main = new Intent(this, MainActivity.class);
        finish();
        startActivity(main);
    }
    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}













