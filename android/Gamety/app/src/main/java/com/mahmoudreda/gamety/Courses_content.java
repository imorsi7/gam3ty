package com.mahmoudreda.gamety;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Courses_content extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_content);

        ArrayList<ListItem> items = new ArrayList<>();
        items.add(new ListItem("", ""));
        items.add(new ListItem("", ""));
        items.add(new ListItem("", ""));
        MyCustomAdapter myadapter = new MyCustomAdapter(items);
        ListView ls = findViewById(R.id.list_view_course);
        ls.setAdapter(myadapter);

        mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    class MyCustomAdapter extends BaseAdapter {

        ArrayList<ListItem> items = new ArrayList<ListItem>();

        MyCustomAdapter(ArrayList<ListItem> items) {
            this.items = items;
        }


        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int i) {
            return items.get(i).name;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            LayoutInflater inflater = getLayoutInflater();
            View view1 = inflater.inflate(R.layout.rowview, null);

            TextView txtname = view1.findViewById(R.id.txtsubjname);
            TextView txtlink = view1.findViewById(R.id.txtsubjlink);
            txtname.setText(items.get(i).name);
            txtlink.setText(items.get(i).link);
            return view1;
        }
    }


}
