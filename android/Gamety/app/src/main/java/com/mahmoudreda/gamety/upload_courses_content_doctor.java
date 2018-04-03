package com.mahmoudreda.gamety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.mahmoudreda.gamety.sign_package.Sign_up;
import com.mahmoudreda.gamety.sign_package.sign_in;

public class upload_courses_content_doctor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_courses_content_doctor);
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
                Intent intent2 = new Intent(upload_courses_content_doctor.this, Sign_up.class);
                startActivity(intent2);
                break;
            case R.id.Log_out:
                Toast.makeText(this, "log out", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(upload_courses_content_doctor.this, sign_in.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
