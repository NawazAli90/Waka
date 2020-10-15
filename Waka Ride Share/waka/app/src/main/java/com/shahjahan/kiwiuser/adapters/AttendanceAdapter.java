package com.shahjahan.kiwiuser.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shahjahan.kiwiuser.R;
import com.shahjahan.kiwiuser.models.ViewAttendance.Data;

import java.util.ArrayList;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.ViewHolder> implements Filterable {

    private Context context;
    private ArrayList<Data> list;
    private ArrayList<Data> filteredList;
    private LayoutInflater inflater;

    public AttendanceAdapter(Context context, ArrayList<Data> list) {
        this.context = context;
        this.list = list;
        filteredList = list;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public AttendanceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.layout_attendance,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AttendanceAdapter.ViewHolder holder, int position) {
        Data detail = filteredList.get(position);
        if(detail != null){
            if(detail.getOrg_type() != null && detail.getOrg_type().getName() != null){
                holder.name.setText(detail.getOrg_type().getName().toUpperCase());
            }
            if(detail.getHistory().getStatus() != null){
                if(detail.getHistory().getStatus().equals("in")){
                    holder.status.setText(detail.getHistory().getStatus());
                }else if(detail.getHistory().getStatus().equals("out")) {
                    holder.status.setText(detail.getHistory().getStatus());
                    holder.status.setTextColor(Color.RED);
                }
            }
            if(detail.getHistory().getDated() != null){
                holder.date.setText(detail.getHistory().getDated());
            }
            if(detail.getHistory().getTimestamp() != null){
                holder.time.setText(detail.getHistory().getTimestamp());
            }
        }
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String s = constraint.toString().toLowerCase();
                if(s.isEmpty()){
                    filteredList = list;
                }else {
                    ArrayList<Data> newFilter = new ArrayList<>();
                    for (Data obj:list){
                        if(obj.getOrg_type() != null && obj.getOrg_type().getName() != null &&
                                obj.getOrg_type().getName().toLowerCase().contains(s)){
                            newFilter.add(obj);
                        }
                    }
                    filteredList = newFilter;
                }
                FilterResults results = new FilterResults();
                results.values = filteredList;
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredList = (ArrayList<Data>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name,status,date,time;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txt_Name);
            time = itemView.findViewById(R.id.txt_timeStamp);
            date = itemView.findViewById(R.id.txt_date);
            status = itemView.findViewById(R.id.status);
        }
    }
}
