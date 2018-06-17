package com.wireupfinland.wireup_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.internal.api.FirebaseNoSignedInUserException;

public class SetProject extends AppCompatActivity {

    private EditText subject;
    private EditText projectName;
    private EditText endDate;
    private EditText addPeople;
    private Button create;

    private FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_project);

        subject = (EditText) findViewById(R.id.setSubject);
        projectName = (EditText) findViewById(R.id.setProjectName);
        endDate = (EditText) findViewById(R.id.setEndDate);
        addPeople = (EditText) findViewById(R.id.addPeople);
        create = (Button) findViewById(R.id.setCreate);

    }
    public void createProject(){

    }
    public void startMainActivity(){
        Intent main = new Intent(this, Main.class);
        startActivity(main);

    }
  //TODO functionality to register new project in the database
}
