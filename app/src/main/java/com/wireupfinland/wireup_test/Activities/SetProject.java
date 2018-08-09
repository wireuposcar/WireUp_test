package com.wireupfinland.wireup_test.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.wireupfinland.wireup_test.DataService.PeopleToAddAdapter;
import com.wireupfinland.wireup_test.R;
import com.wireupfinland.wireup_test.Services.DataService;
import com.wireupfinland.wireup_test.Services.PeopleToAdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


//TODO filter for users when you type in addPeople textfield and display them in recyclerView
//TODO add users to an array when you click on them in the recyclerView

public class SetProject extends AppCompatActivity {

    private ProgressDialog mProgressDialog;
    private DatabaseReference mPostDatabase;
    private FirebaseDatabase mDatabase;
    private FirebaseUser mUser;
    private FirebaseAuth mAuth;
    private EditText subject;
    private EditText projectName;
    private EditText endDate;
    private EditText addPeople;
    private Button create;
    private DatabaseReference mPeopleToAdd;
    private ArrayList<String> peopleAddedArrayList = new ArrayList<String>();
    private ArrayList<String> mKeys = new ArrayList<>();

    private String mCurrentUserId;
    private TextView peopleAddedTxtView;

    private RecyclerView mPeopleAdded;
    private LinearLayoutManager mLayoutManager;



    private List<PeopleToAdd> listItems;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_project);

        subject = (EditText) findViewById(R.id.setSubject);
        projectName = (EditText) findViewById(R.id.setProjectName);
        endDate = (EditText) findViewById(R.id.setEndDate);
        addPeople = (EditText) findViewById(R.id.addPeople);
        create = (Button) findViewById(R.id.setCreate);
        peopleAddedTxtView = (TextView) findViewById(R.id.peopleAddedTxtView);


        mProgressDialog = new ProgressDialog(this);
        mDatabase = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        mCurrentUserId = mAuth.getCurrentUser().getUid();

        recyclerView = (RecyclerView) findViewById(R.id.peopleSearchedForRecyclerView);
        //recyclerView.hasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();

        for(int i = 0; i<=10; i++) {
            PeopleToAdd listItem = new PeopleToAdd("Test" + 1+1, "Test again");
            listItems.add(listItem);
        }

        adapter = new PeopleToAddAdapter(this, listItems);

        recyclerView.setAdapter(adapter);


        //init();



        //mPeopleToAdd = FirebaseDatabase.getInstance().getReference().child("users").child("Jakobstads Gymnasium");
        mPeopleToAdd = mDatabase.getReference().child("users").child("Jakobstads Gymnasium");



        mPeopleToAdd.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                //showPeople(dataSnapshot);

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mPostDatabase = FirebaseDatabase.getInstance().getReference().child("groups").child("android"); //remove child android


        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createProject();
            }
        });

    }



    private void init() {
        //mPeopleAdded = (RecyclerView) findViewById(R.id.peopleSearchedForRecyclerView);
        //mLayoutManager = new LinearLayoutManager(this);
        //mPeopleAdded.setLayoutManager(mLayoutManager);
    }





    private void showPeople(DataSnapshot dataSnapshot) {
        for (DataSnapshot ds: dataSnapshot.getChildren()) {
            PeopleToAdd addedPeople = new PeopleToAdd();
            addedPeople.setEmail(ds.getValue(PeopleToAdd.class).getEmail());


           //ArrayList<String> peopleAdded = new ArrayList<>();
           //peopleAdded.add(addedPeople.getEmail());
            //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_2, peopleAdded);
            //mListView.setAdapter(adapter);
        }
    }

    public void createProject(){
        final String subj = subject.getText().toString().trim();
        final String projectNm = projectName.getText().toString().trim();
        final String endDt = endDate.getText().toString();
        final String members = addPeople.getText().toString();

        if (!TextUtils.isEmpty(subj) && !TextUtils.isEmpty(projectNm) && !TextUtils.isEmpty(endDt) && !TextUtils.isEmpty(members)) {
            mProgressDialog.setMessage("Creating new project...");
            mProgressDialog.show();

            DatabaseReference createNewProject = mPostDatabase.push();

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
        startMainActivity();

    }

    public void startMainActivity(){
        Intent main = new Intent(this, Main.class);
        startActivity(main);
        finish();

    }

}
