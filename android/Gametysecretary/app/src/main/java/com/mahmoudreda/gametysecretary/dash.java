package com.mahmoudreda.gametysecretary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class dash extends AppCompatActivity {

    Button l, sh ;

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);

        l = (Button) findViewById(R.id.button4);
        sh = (Button) findViewById(R.id.button5);

        spinner = (Spinner) findViewById(R.id.spinner) ;
        adapter = ArrayAdapter.createFromResource(this, R.array.Study_Group_names, android.R.layout.simple_spinner_item  );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent link= new Intent(dash.this, Link.class);
                startActivity(link);

            }
        });

        sh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shedule = new Intent(dash.this, Schedule.class);
                startActivity(shedule);
            }
        });
    }
}
