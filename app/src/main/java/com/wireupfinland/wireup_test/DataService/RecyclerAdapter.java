package com.wireupfinland.wireup_test.DataService;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.wireupfinland.wireup_test.Activities.Main;
import com.wireupfinland.wireup_test.Activities.Project;
import com.wireupfinland.wireup_test.R;
import com.wireupfinland.wireup_test.Services.DataService;

import java.util.List;

import static android.content.Intent.getIntent;
import static android.content.Intent.makeRestartActivityTask;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private Context context;
    private List<DataService> serviceList;


    public RecyclerAdapter(Context context, List<DataService> list) {
        this.context = context;
        this.serviceList = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.groupchat_row, parent, false); //maybe wrong view
        return new ViewHolder(view, context);

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        final DataService dataService = serviceList.get(position);

        holder.subject.setText(dataService.getSubject());
        holder.projectName.setText(dataService.getProjectName());
        //holder.endDate.setText(dataService.endDate);
        //holder.peopleAdded.setText(dataService.members);

        holder.deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                deleteProject("-LJmkQTcH88vMg065-uJ");
                System.out.println(FirebaseDatabase.getInstance().getReference().child("groups").child("android"));
              FirebaseDatabase.getInstance().getReference().child("groups").child("android").child("-LJofAcsmvtbfgnh4mQi").removeValue();
          //      ystem.out.println(FirebaseDatabase.getInstance().getReference(key));
              //  System.out.println(key);    //-LJmB_EiQVE-qte5tj8w
            //    FirebaseDatabase.getInstance().getReference(key).removeValue();
             //   FirebaseDatabase.getInstance().getReference().child("groups").child("android").removeValue();

            }
        });


        holder.subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Project.class);
                context.startActivity(intent);

            }
        });

    }
    private void deleteProject(String projectid){
        DatabaseReference dProject=FirebaseDatabase.getInstance().getReference("groups").child("android").child(projectid);
        dProject.removeValue();


    }

    @Override
    public int getItemCount() {
        return serviceList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView subject;
        public TextView projectName;
        public ImageButton deletebtn;
        //public TextView endDate;
        //public TextView peopleAdded;
        String userid;

        RelativeLayout parentLayout;

        public ViewHolder(View view, Context ctx) {
            super(view);

            context = ctx;

            parentLayout = view.findViewById(R.id.parentLayout);

            subject = (TextView) view.findViewById(R.id.projectSubject);
            projectName = (TextView) view.findViewById(R.id.projectName);
            deletebtn = (ImageButton) view.findViewById(R.id.deleteBtn);
            //endDate = (TextView) view.findViewById(R.id.setEndDate);
            //peopleAdded = (TextView) view.findViewById(R.id.addPeople);

            userid = null;

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // next activity
                }
            });





        }
    }
}
