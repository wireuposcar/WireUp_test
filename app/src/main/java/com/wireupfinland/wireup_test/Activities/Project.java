package com.wireupfinland.wireup_test.Activities;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.wireupfinland.wireup_test.DataService.RecyclerAdapter;
import com.wireupfinland.wireup_test.R;

public class Project extends AppCompatActivity {
    private ProgressDialog progressDialog;
    private EditText endDate;
    private ImageView dropbox;
    private ImageView evernote;
    private ImageView docs;
    private RecyclerView tasks;
    private Button chatBtn;
    private Context context;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        dropbox = (ImageView) findViewById(R.id.imageButtonDropbox);
        evernote = (ImageView) findViewById(R.id.imageButtonEvernote);
        docs = (ImageView) findViewById(R.id.imageButtonDocs);
        endDate = (EditText) findViewById(R.id.setEndDate);
        progressDialog = new ProgressDialog(this);
        chatBtn = (Button) findViewById(R.id.chatBtn);

        chatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                  Intent intent = new Intent(getApplicationContext(), Chat.class);
                  startActivity(intent);
                  finish();
            }
        });








    }
}
