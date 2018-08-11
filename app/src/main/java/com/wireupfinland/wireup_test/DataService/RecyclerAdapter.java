package com.wireupfinland.wireup_test.DataService;

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

import com.wireupfinland.wireup_test.Activities.Chat;
import com.wireupfinland.wireup_test.R;
import com.wireupfinland.wireup_test.Services.DataService;

import java.util.List;

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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        DataService dataService = serviceList.get(position);

        holder.subject.setText(dataService.getSubject());
        holder.projectName.setText(dataService.getProjectName());
        //holder.endDate.setText(dataService.endDate);
        //holder.peopleAdded.setText(dataService.members);


        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Chat.class);
                context.startActivity(intent);
            }
        });

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
