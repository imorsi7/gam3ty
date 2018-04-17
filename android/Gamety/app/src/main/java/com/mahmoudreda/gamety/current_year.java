package com.mahmoudreda.gamety;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class current_year extends AppCompatActivity {
    String years, departments, smesters;
    Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_year);
        ok = findViewById(R.id.button_ok);
        save();
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(current_year.this, "Saved successfully", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void save() {
        Spinner mySpinner = findViewById(R.id.spinner1);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.year));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    years = "Firstyear";
                    SharedPreferences sharedpreferences_year = getSharedPreferences("year", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences_year.edit();
                    editor.putString("year", years);
                    editor.apply();
                } else if (i == 1) {
                    years = "Secondyear";
                    SharedPreferences sharedpreferences_year = getSharedPreferences("year", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences_year.edit();
                    editor.putString("year", years);
                    editor.apply();
                } else if (i == 2) {
                    years = "Thirdyear";
                    SharedPreferences sharedpreferences_year = getSharedPreferences("year", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences_year.edit();
                    editor.putString("year", years);
                    editor.apply();
                } else if (i == 3) {
                    years = "Fourthyear";
                    SharedPreferences sharedpreferences_year = getSharedPreferences("year", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences_year.edit();
                    editor.putString("year", years);
                    editor.apply();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner mySpinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.department));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner2.setAdapter(myAdapter2);
        mySpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    departments = "General";
                    SharedPreferences sharedpreferences_department = getSharedPreferences("department", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences_department.edit();
                    editor.putString("department", departments);
                    editor.apply();
                } else if (i == 1) {
                    departments = "CS";
                    SharedPreferences sharedpreferences_department = getSharedPreferences("department", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences_department.edit();
                    editor.putString("department", departments);
                    editor.apply();
                } else if (i == 2) {
                    departments = "IS";
                    SharedPreferences sharedpreferences_department = getSharedPreferences("department", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences_department.edit();
                    editor.putString("department", departments);
                    editor.apply();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner mySpinner3 = findViewById(R.id.spinner3);
        ArrayAdapter<String> myAdapter3 = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.semestr));
        myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner3.setAdapter(myAdapter3);
        mySpinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    smesters = "1";
                    SharedPreferences sharedpreferences_semester = getSharedPreferences("semester", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences_semester.edit();
                    editor.putString("semester", smesters);
                    editor.apply();
                } else if (i == 1) {
                    smesters = "2";
                    SharedPreferences sharedpreferences_semester = getSharedPreferences("semester", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences_semester.edit();
                    editor.putString("semester", smesters);
                    editor.apply();
                } else if (i == 2) {
                    smesters = "3";
                    SharedPreferences sharedpreferences_semester = getSharedPreferences("semester", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences_semester.edit();
                    editor.putString("semester", smesters);
                    editor.apply();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
