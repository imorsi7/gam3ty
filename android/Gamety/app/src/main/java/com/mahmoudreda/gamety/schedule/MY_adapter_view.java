package com.mahmoudreda.gamety.schedule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mahmoudreda.gamety.R;

import java.util.ArrayList;

/**
 * Created by mahmoud reda on 21/04/2018.
 */

public class MY_adapter_view extends BaseAdapter {
    private Context c;
    private ArrayList<item_schedule> list;

    MY_adapter_view(Context c, ArrayList<item_schedule> list) {
        this.c = c;
        this.list = list;
    }

    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View view, ViewGroup group) {
        LayoutInflater inf = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null)
            view = inf.inflate(R.layout.customer_list_schedule, null);
        TextView x = view.findViewById(R.id.time);
        TextView y = view.findViewById(R.id.teacher_name);
        TextView f = view.findViewById(R.id.course_name);
        TextView k = view.findViewById(R.id.hall);
        TextView l = view.findViewById(R.id.day);

        x.setText(list.get(position).getTime());
        y.setText(list.get(position).getTeacher_name());
        f.setText(list.get(position).getCourse_name());
        k.setText(list.get(position).getHall());
        l.setText(list.get(position).getDay());
        return view;
    }
}