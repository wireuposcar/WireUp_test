package com.wireupfinland.wireup_test.DataService;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
                .inflate(R.layout.activity_set_project, parent, false); //maybe wrong view

        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        DataService dataService = serviceList.get(position);

        holder.subject.setText(dataService.subject);
        holder.projectName.setText(dataService.projectName);
        holder.endDate.setText(dataService.endDate);
        holder.peopleAdded.setText(dataService.people);


        //TODO format date

    }

    @Override
    public int getItemCount() {
        return serviceList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView subject;
        public TextView projectName;
        public TextView endDate;
        public TextView peopleAdded;
        String userid;

        public ViewHolder(View view, Context ctx) {
            super(view);

            context = ctx;

            subject = (TextView) view.findViewById(R.id.setSubject);
            projectName = (TextView) view.findViewById(R.id.setProjectName);
            endDate = (TextView) view.findViewById(R.id.setEndDate);
            peopleAdded = (TextView) view.findViewById(R.id.addPeople);

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
