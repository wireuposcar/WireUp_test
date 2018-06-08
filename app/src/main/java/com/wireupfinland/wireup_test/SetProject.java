package com.wireupfinland.wireup_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.internal.api.FirebaseNoSignedInUserException;

public class SetProject extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_project);
    }

    private void getData(){
        EditText edit1 = (EditText) findViewById(R.layout.activity_set_project);
    }
  //TODO functionality to register new project in the database
}
