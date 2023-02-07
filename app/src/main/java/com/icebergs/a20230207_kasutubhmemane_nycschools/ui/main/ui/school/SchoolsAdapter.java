package com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.ui.school;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.icebergs.a20230207_kasutubhmemane_nycschools.R;
import com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.database.model.SchoolDTOEntity;
import com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.util.OnItemClickListener;

import java.util.ArrayList;

public class SchoolsAdapter extends RecyclerView.Adapter<SchoolsAdapter.ViewHolder> {

    private ArrayList<SchoolDTOEntity> schools;
    private OnItemClickListener onItemClickListener;

    public SchoolsAdapter(ArrayList<SchoolDTOEntity> schools, OnItemClickListener listener) {
        this.schools = schools;
        this.onItemClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.school_row_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SchoolDTOEntity school = schools.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(school);
            }
        });
        holder.schoolNameTv.setText(school.getSchoolName());
        holder.schoolDbnTv.setText(school.getDbn());
        holder.schoolNeighborhoodTv.setText(school.getNeighborhood());
    }

    @Override
    public int getItemCount() {
        return schools.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView schoolNameTv;
        TextView schoolDbnTv;
        TextView schoolNeighborhoodTv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            schoolNameTv = itemView.findViewById(R.id.schoolNameTv);
            schoolDbnTv = itemView.findViewById(R.id.schoolDbnTv);
            schoolNeighborhoodTv = itemView.findViewById(R.id.schoolNeighborhoodTv);
        }
    }

    public void submitList(ArrayList<SchoolDTOEntity> schoolsList) {
        this.schools.clear();
        this.schools.addAll(schoolsList);
        notifyDataSetChanged();
    }
}