package com.mahmoudreda.gamety.dash_board;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mahmoudreda.gamety.R;

/**
 * Created by mahmoud reda on 02/04/2018.
 */

public class MY_adapter extends BaseAdapter {
    String[] title;
    String[] description;
    LayoutInflater inf;

    public MY_adapter(String title[], String[] description) {
        this.title = title;
        this.description = description;
    }

    public int getCount() {
        return title.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup group) {
        inf = (LayoutInflater) group.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = view;
        if (v == null)
            v = inf.inflate(R.layout.customer_list_dash_student, null);
        TextView x = v.findViewById(R.id.title_customer);
        TextView y = v.findViewById(R.id.description_customer);
        x.setText(title[position]);
        y.setText(description[position]);
        return v;
    }
}
