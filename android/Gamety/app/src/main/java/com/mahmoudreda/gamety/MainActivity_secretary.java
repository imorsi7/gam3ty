package com.mahmoudreda.gamety;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mahmoudreda.gamety.sign_package.Sign_up;
import com.mahmoudreda.gamety.sign_package.sign_in;

public class MainActivity_secretary extends AppCompatActivity {
    Button x, y, k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_secretary);

        x = findViewById(R.id.Button_schedule_sec);
        y = findViewById(R.id.Button_dash_board_sec);
        k = findViewById(R.id.Button_link_techer);
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), schedule.class);
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
                Toast.makeText(this, "current year", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(MainActivity_secretary.this, Sign_up.class);
                startActivity(intent2);
                break;
            case R.id.Log_out:
                Toast.makeText(this, "log out", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(MainActivity_secretary.this, sign_in.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);

    }
}
