package com.mahmoudreda.gamety.dash_board;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mahmoudreda.gamety.R;

import java.util.ArrayList;

/**
 * Created by mahmoud reda on 02/04/2018.
 */

public class MY_adapter extends BaseAdapter {
    LayoutInflater inf;
    Context c;
    ArrayList<item_Dash_Board> list;

    public MY_adapter(Context c, ArrayList<item_Dash_Board> list) {
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
        inf = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null)
            view = inf.inflate(R.layout.customer_list_dash_student, null);
        TextView x = view.findViewById(R.id.title_customer);
        TextView y = view.findViewById(R.id.description_customer);
        x.setText(list.get(position).getTitle());
        y.setText(list.get(position).getDesc());
        return view;
    }
}
