package com.wireupfinland.wireup_test;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int loginListener = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(loginListener == 0) {

            Intent login = new Intent(this, Login.class);
            startActivity(login);
            loginListener ++;
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
}
