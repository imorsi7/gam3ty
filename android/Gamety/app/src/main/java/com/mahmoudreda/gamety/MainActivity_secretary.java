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

import com.mahmoudreda.gamety.course_content.Courses_content;
import com.mahmoudreda.gamety.dash_board.ADV_dash_board_sec;
import com.mahmoudreda.gamety.dash_board.ADV_dash_board_sec_display_delete;
import com.mahmoudreda.gamety.exam_result.upload_result;
import com.mahmoudreda.gamety.schedule.select_schedule;
import com.mahmoudreda.gamety.sign_package.sign_in;

public class MainActivity_secretary extends AppCompatActivity {
    Button x, y, k, l, r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_secretary);

        x = findViewById(R.id.Button_schedule_sec);
        y = findViewById(R.id.Button_dash_board_sec);
        k = findViewById(R.id.Button_link_techer);
        l = findViewById(R.id.Button_schedule_sec_display);
        r = findViewById(R.id.result);
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), select_schedule.class);
                startActivity(i);
            }
        });
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ADV_dash_board_sec_display_delete.class);
                startActivity(i);
            }
        });
        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ADV_dash_board_sec.class);
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
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), upload_result.class);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation_sec, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case R.id.Log_out:
                Toast.makeText(this, "log out", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(MainActivity_secretary.this, sign_in.class);
                startActivity(intent1);
                finish();
                SharedPreferences sharedpreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("Name", null);
                editor.apply();
                break;
        }
        return super.onOptionsItemSelected(item);

    }
}
