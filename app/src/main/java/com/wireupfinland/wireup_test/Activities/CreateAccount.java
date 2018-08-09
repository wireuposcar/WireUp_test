package com.wireupfinland.wireup_test.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.wireupfinland.wireup_test.R;

import java.util.ArrayList;

public class CreateAccount extends AppCompatActivity {


    private EditText fullname;
    private EditText email;
    private EditText password;
    private EditText school;
    private EditText schoolCode;
    private Button createAccountBtn;

    private DatabaseReference mDatabaseReference;
    private FirebaseDatabase mDatabase;
    private FirebaseAuth mAuth;
    private ProgressDialog mProgressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__create_account);

        mDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mDatabase.getReference().child("users");

        mAuth = FirebaseAuth.getInstance();

        mProgressDialog = new ProgressDialog(this);

        fullname = (EditText) findViewById(R.id.fullNameAct);
        email = (EditText) findViewById(R.id.emailAct);
        password = (EditText) findViewById(R.id.passwordAct);
        //school = (EditText) findViewById(R.id.schoolList);
        schoolCode = (EditText) findViewById(R.id.schoolCodeAct);
        createAccountBtn = (Button) findViewById(R.id.createAccountAct);





        String[] schools = new String[]{
                "Please choose a school",
                "Jakobstads Gymnasium",
                "Pedersore Gymnaisum"
        };

        final String[] schoolCodeArray = new String[] {
                "Youwontgetin",
                "xC14mQch",
                "jh82Qnsp"
        };

        Spinner schoolList = findViewById(R.id.schoolList);

        ArrayAdapter<String> schoolListAdapter = new ArrayAdapter<String>(CreateAccount.this, android.R.layout.simple_spinner_dropdown_item, schools);

        schoolList.setAdapter(schoolListAdapter);

        schoolList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (schoolCodeArray[position].equals(schoolCode.getText().toString().trim())) {
                    createAccountBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            createNewAccount();
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }







    public void createNewAccount() {

        Spinner selectedSchool = findViewById(R.id.schoolList);

        String selectedSchoolData = selectedSchool.getItemAtPosition(selectedSchool.getSelectedItemPosition()).toString();

        final String name = fullname.getText().toString().trim();
        final String em = email.getText().toString().trim();
        final String pwd = password.getText().toString();
        final String sch = selectedSchoolData.toString();
        final String schCode = schoolCode.getText().toString().trim();



        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(em) && !TextUtils.isEmpty(pwd) && !TextUtils.isEmpty(sch) && !TextUtils.isEmpty(schCode)) {
            mProgressDialog.setMessage("Creating account....");
            mProgressDialog.show();

            mAuth.createUserWithEmailAndPassword(em, pwd)
                    .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            if (authResult != null) {

                                String userid = mAuth.getCurrentUser().getUid();
                                DatabaseReference currentUserDb = mDatabaseReference.child(userid);
                                currentUserDb.child("firstName").setValue(name);
                                currentUserDb.child("email").setValue(em);
                                currentUserDb.child("schoolCode").setValue(schCode);
                                currentUserDb.child("schoolName").setValue(sch);
                                DatabaseReference userSchoolDirectory = mDatabaseReference.child(sch).child(userid);
                                userSchoolDirectory.child("email").setValue(em);
                                userSchoolDirectory.child("provider").setValue("Firebase");


                                mProgressDialog.dismiss();

                                //log in users

                                Intent intent = new Intent(CreateAccount.this, Main.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                                finish();

                            }
                        }
                    });
        }

    }
}























