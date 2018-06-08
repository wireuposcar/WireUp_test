package com.wireupfinland.wireup_test;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private FirebaseListAdapter<ChatMessage> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        boolean loginListener = false;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(!loginListener) {

            Intent login = new Intent(this, Login.class);
            startActivity(login);
            loginListener = true;
        }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.newProject);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //
                startSetProject();
            }
        });
    }
    private void startSetProject() {
        Intent project = new Intent(this, SetProject.class);
        startActivity(project);
    }
    private void DisplayProject(){
        //TODO fetch and display projects from database
    }
    private void startChat(){

    }


}
