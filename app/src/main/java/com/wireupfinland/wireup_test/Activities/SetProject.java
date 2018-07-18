package com.wireupfinland.wireup_test.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.wireupfinland.wireup_test.R;
import com.wireupfinland.wireup_test.Services.DataService;

import java.util.HashMap;
import java.util.Map;

public class SetProject extends AppCompatActivity {

    private ProgressDialog mProgressDialog;
    private DatabaseReference mPostDatabse;
    private FirebaseDatabase mDatabase;
    private FirebaseUser mUser;
    private FirebaseAuth mAuth;
    private EditText subject;
    private EditText projectName;
    private EditText endDate;
    private EditText addPeople;
    private Button create;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_project);

        subject = (EditText) findViewById(R.id.setSubject);
        projectName = (EditText) findViewById(R.id.setProjectName);
        endDate = (EditText) findViewById(R.id.setEndDate);
        addPeople = (EditText) findViewById(R.id.addPeople);
        create = (Button) findViewById(R.id.setCreate);

        mProgressDialog = new ProgressDialog(this);
        mDatabase = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        //mDatabaseReference = mDatabase.getReference().child("AndroidTest"); //change reference child
        mPostDatabse = FirebaseDatabase.getInstance().getReference().child("groups");


        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createProject();
                
            }
        });

    }

    public void createProject(){
        final String subj = subject.getText().toString().trim();
        final String projectNm = projectName.getText().toString().trim();
        final String endDt = endDate.getText().toString();
        final String members = addPeople.getText().toString();

        if (!TextUtils.isEmpty(subj) && !TextUtils.isEmpty(projectNm) && !TextUtils.isEmpty(endDt) && !TextUtils.isEmpty(members)) {
            mProgressDialog.setMessage("Creating new project...");
            mProgressDialog.show();

            DatabaseReference createNewProject = mPostDatabse.push();

            Map<String, String> dataToSave = new HashMap<>();
            dataToSave.put("subject", subj);
            dataToSave.put("projectName", projectNm);
            dataToSave.put("endDate", endDt);
            dataToSave.put("members", members);
            dataToSave.put("userid", mUser.getUid());
            dataToSave.put("creationDate", String.valueOf(java.lang.System.currentTimeMillis()));
            dataToSave.put("dropbox", "");
            dataToSave.put("evernote", "");
            dataToSave.put("googleDocs", "");


            createNewProject.setValue(dataToSave);

            mProgressDialog.dismiss();

            startActivity(new Intent(SetProject.this, Main.class));

            //TODO dissable create account button and cleare all fields and enable button


            //DataService dataService = new DataService(subj, projectNm, endDt, members, "", "", "", "", "");

            //mPostDatabse.setValue(dataService).addOnSuccessListener(new OnSuccessListener<Void>() {
               // @Override
              //  public void onSuccess(Void aVoid) {
                //    Toast.makeText(getApplicationContext(), "Group created", Toast.LENGTH_LONG).show();
                //}
            //});

        }

    }


    public void startMainActivity(){
        Intent main = new Intent(this, Main.class);
        startActivity(main);

    }
  //TODO functionality to register new project in the database

}
