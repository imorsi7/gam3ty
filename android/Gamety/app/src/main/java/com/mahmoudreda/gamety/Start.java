package com.mahmoudreda.gamety;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Start extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        final Button y = findViewById(R.id.button_sign_up);
        final Button x = findViewById(R.id.button_sign_in);

        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), sign_in.class);
                startActivity(i);
            }
        });
        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Sign_up.class);
                startActivity(i);
            }
        });
        SharedPreferences sharedpreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        String Name = sharedpreferences.getString("Name", null); // getting String;
        if (Name.length() == 8 || Name.length() == 6 || Name.length() == 4) {
            Intent i = new Intent(getApplicationContext(), schedule.class);
            startActivity(i);

        }

    }
}
