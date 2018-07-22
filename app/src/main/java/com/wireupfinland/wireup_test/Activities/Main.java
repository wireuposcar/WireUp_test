package com.wireupfinland.wireup_test.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.wireupfinland.wireup_test.DataService.RecyclerAdapter;
import com.wireupfinland.wireup_test.R;
import com.wireupfinland.wireup_test.Services.DataService;

import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity {
    private FloatingActionButton newProject;
    private FloatingActionButton chat;
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private List<DataService> grouplist;
    private Button project;

    private FirebaseDatabase mDatabase;
    private DatabaseReference mDatabaseReference;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        mDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mDatabase.getReference().child("groups");
        mDatabaseReference.keepSynced(true);

        grouplist = new ArrayList<>();

        //recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        newProject = (FloatingActionButton) findViewById(R.id.createNewProjectBtn);
        chat = (FloatingActionButton) findViewById(R.id.logoutBtn);
        project = (Button) findViewById(R.id.project);
        startChat();
        startSetProject();
        startDisplayProject();
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

    private void startDisplayProject() {
        project.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Project.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void startChat() {
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

   // @Override
    //public boolean onOptionsItemSelected(MenuItem item) {
      //  switch (item.getItemId()) {
        //    case R.id.createNewProjectBtn:
                //if (mUser != null && mAuth != null) {

                  //  startActivity(new Intent(Main.this, SetProject.class));
                //    finish();
              //  }
            //break;
            //case R.id.logoutBtn:
                //if (mUser != null && mAuth != null) {

                //    mAuth.signOut();
              //      startActivity(new Intent(Main.this, Landingpage.class));
            //        finish();
          //      }

        //}
      //  return super.onOptionsItemSelected(item);
    //};
}
