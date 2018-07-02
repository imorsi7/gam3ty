package com.mahmoudreda.gamety.schedule;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mahmoudreda.gamety.R;

import java.util.ArrayList;

/**
 * Created by mahmoud reda on 27/05/2018.
 */

@SuppressWarnings("DefaultFileTemplate")
public class recycleadapter extends RecyclerView.Adapter<recycleadapter.ViewHolder> {
    private ArrayList<list_Item_sch> list = new ArrayList<>();
    public Context context;


    recycleadapter(ArrayList<list_Item_sch> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view1 = inflater.inflate(R.layout.customer_list_schedule, null);
        return new ViewHolder(view1);
    }

    @Override
    public void onBindViewHolder(final recycleadapter.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        // - replace the contents of the view with that element
        holder.teache_name.setText(list.get(position).getTeacher_name());
        holder.coure_name.setText(list.get(position).getCourse_name());
        holder.hall.setText(list.get(position).getHall());
        holder.day.setText(list.get(position).getDay());
        holder.time.setText(list.get(position).getTime());

    }

    // Return the size of your database (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView time, hall, teache_name, coure_name, day;

        ViewHolder(View itemView) {
            super(itemView);
            day = itemView.findViewById(R.id.day);
            teache_name = itemView.findViewById(R.id.teacher_name);
            time = itemView.findViewById(R.id.time);
            hall = itemView.findViewById(R.id.hall);
            coure_name = itemView.findViewById(R.id.course_name);
        }
    }
}
