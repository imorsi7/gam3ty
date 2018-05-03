package com.mahmoudreda.gamety;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mahmoudreda.gamety.course_content.Courses_content;
import com.mahmoudreda.gamety.dash_board.ADV_dash_board;
import com.mahmoudreda.gamety.schedule.current_year;
import com.mahmoudreda.gamety.schedule.schedule_view;
import com.mahmoudreda.gamety.sign_package.sign_in;

public class MainActivity_student extends AppCompatActivity {
    Button x, y, k;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_student);
        x = findViewById(R.id.Button_Schedule);
        y = findViewById(R.id.Button_dash_board);
        k = findViewById(R.id.Button_courses_content);

        SharedPreferences sharedpreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        id = sharedpreferences.getString("Name", null); // getting String;

        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), schedule_view.class);
                startActivity(i);
            }
        });
        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ADV_dash_board.class);
                startActivity(i);
            }
        });
        k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Courses_content.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();
        switch (id) {
            case R.id.navigation_dashboard:
                Intent intent2 = new Intent(MainActivity_student.this, current_year.class);
                startActivity(intent2);
                break;
            case R.id.Log_out:
                Toast.makeText(this, "log out", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(MainActivity_student.this, sign_in.class);
                startActivity(intent1);
                finish();
                SharedPreferences sharedpreferencess = getSharedPreferences("data", Context.MODE_PRIVATE);
                SharedPreferences.Editor editors = sharedpreferencess.edit();
                editors.putString("Name", null);
                editors.apply();
                break;
        }
        return super.onOptionsItemSelected(item);

    }


}
/*
*
* startActivity(new Intent(Intent.ACTION_SEND , Uri.parse("http:///www.google.com/")));
* */
