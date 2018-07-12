package com.wireupfinland.wireup_test.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.wireupfinland.wireup_test.R;

public class Main extends AppCompatActivity {
    private FloatingActionButton newProject;
    private FloatingActionButton chat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newProject = (FloatingActionButton) findViewById(R.id.newProject);
        chat = (FloatingActionButton) findViewById(R.id.chattButton);
        startChat();
        startSetProject();

    }
    private void startSetProject() {


        newProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SetProject.class);
                startActivity(intent);
                finish();

            }
        });
        }
    private void startDisplayProject(){

        //TODO fetch and display projects from database
    }
    private void startChat(){
        //TODO: add chat according to requirements.

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Chat.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
