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

import com.mahmoudreda.gamety.course_content.course_content_student;
import com.mahmoudreda.gamety.dash_board.ADV_dash_board;
import com.mahmoudreda.gamety.exam_result.result_view;
import com.mahmoudreda.gamety.profile.profile_student;
import com.mahmoudreda.gamety.schedule.current_year;
import com.mahmoudreda.gamety.schedule.schedule_view;
import com.mahmoudreda.gamety.sign_package.sign_in;
import com.mahmoudreda.gamety.toalbar.about_app;
import com.mahmoudreda.gamety.toalbar.qr;

public class MainActivity_student extends AppCompatActivity {
    Button x, y, k, r;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_student);
        x = findViewById(R.id.Button_Schedule);
        y = findViewById(R.id.Button_dash_board);
        k = findViewById(R.id.Button_courses_content);
        r = findViewById(R.id.Button_result);

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
                Intent i = new Intent(getApplicationContext(), course_content_student.class);
                startActivity(i);
            }
        });

        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), result_view.class);
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
            case R.id.profile:
                Intent intent3 = new Intent(MainActivity_student.this, profile_student.class);
                startActivity(intent3);
                break;
            case R.id.current_year:
                Intent intent2 = new Intent(MainActivity_student.this, current_year.class);
                startActivity(intent2);
                break;
            case R.id.share_app:
                Intent intent5 = new Intent(MainActivity_student.this, qr.class);
                startActivity(intent5);
                break;
            case R.id.about_app:
                Intent intent6 = new Intent(MainActivity_student.this,about_app.class);
                startActivity(intent6);
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
