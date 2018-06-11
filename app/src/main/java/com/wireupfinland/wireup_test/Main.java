package com.wireupfinland.wireup_test;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Set;

public class Main extends AppCompatActivity {
    private FloatingActionButton newProject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newProject = (FloatingActionButton) findViewById(R.id.newProject);
        startSetProject();
    }
    private void startSetProject() {


        newProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getApplicationContext(), SetProject.class);
                startActivity(intent);

            }
        });
        }
    private void DisplayProject(){
        //TODO fetch and display projects from database
    }
    private void startChat(){
        //TODO: add chat according to requirements.
    }
}
