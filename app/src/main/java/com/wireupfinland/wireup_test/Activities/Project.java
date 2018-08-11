package com.wireupfinland.wireup_test.Activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageView;

import com.wireupfinland.wireup_test.R;

public class Project extends AppCompatActivity {
    private ProgressDialog progressDialog;
    private EditText endDate;
    private ImageView dropbox;
    private ImageView evernote;
    private ImageView docs;
    private RecyclerView tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        dropbox = (ImageView) findViewById(R.id.imageButtonDropbox);
        evernote = (ImageView) findViewById(R.id.imageButtonEvernote);
        docs =(ImageView) findViewById(R.id.imageButtonDocs);
        endDate = (EditText) findViewById(R.id.setEndDate);
        progressDialog = new ProgressDialog(this);





    }
}
