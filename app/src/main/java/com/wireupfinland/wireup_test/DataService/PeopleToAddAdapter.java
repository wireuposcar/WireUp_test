package com.wireupfinland.wireup_test.DataService;

import android.app.LauncherActivity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.ListView;
import android.widget.TextView;
import java.util.List;

import com.wireupfinland.wireup_test.R;
import com.wireupfinland.wireup_test.Services.PeopleToAdd;

import java.util.ArrayList;
import java.util.List;

public class PeopleToAddAdapter extends RecyclerView.Adapter<PeopleToAddAdapter.MyViewHolder> {
    private Context context;
    //private ArrayList<PeopleToAdd> mPeopleToAdd;
    private List<PeopleToAdd> mPeopleToAdd;



    public PeopleToAddAdapter(Context con, List<PeopleToAdd> list) {
        this.context = con;
        this.mPeopleToAdd = list;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.people_to_add_listview, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PeopleToAddAdapter.MyViewHolder holder, int position) {

        PeopleToAdd listItem = mPeopleToAdd.get(position);
        holder.emailLbl.setText(listItem.getEmail());
    }

    @Override
    public int getItemCount() {
        return mPeopleToAdd.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView emailLbl;

        public MyViewHolder(View itemView) {
            super(itemView);
            emailLbl = (TextView) itemView.findViewById(R.id.emailLbl);
        }
    }
}
