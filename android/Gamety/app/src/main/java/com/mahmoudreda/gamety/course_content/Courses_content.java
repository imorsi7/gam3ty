package com.mahmoudreda.gamety.course_content;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mahmoudreda.gamety.R;

import java.util.HashMap;
import java.util.Map;

public class Courses_content extends AppCompatActivity {
    String teacher_ids, course_names, times, holles, days, years, departments, smesters;
    Button upload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cours_content);

        upload = findViewById(R.id.button_upload_schedule);

        Spinner mySpinner = findViewById(R.id.spinner1);
        final ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this,
            android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.teacher_name));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0)
                    teacher_ids = "123456";
                else if (i == 1)
                    teacher_ids = "123450";
                else if (i == 2)
                    teacher_ids = "123455";
                else if (i == 3)
                    teacher_ids = "123444";
                else if (i == 4)
                    teacher_ids = "222222";
                else if (i == 5)
                    teacher_ids = "656535";
                else if (i == 6)
                    teacher_ids = "999999";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner mySpinner2 = findViewById(R.id.spinner2);
        final ArrayAdapter<String> myAdapter2 = new ArrayAdapter<>(this,
            android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.course_name));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner2.setAdapter(myAdapter2);
        mySpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0)
                    course_names = "111";
                else if (i == 1)
                    course_names = "222";
                else if (i == 2)
                    course_names = "333";
                else if (i == 3)
                    course_names = "444";
                else if (i == 4)
                    course_names = "555";
                else if (i == 5)
                    course_names = "666";
                else if (i == 6)
                    course_names = "777";
                else if (i == 7)
                    course_names = "888";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner mySpinner3 = findViewById(R.id.spinner3);
        final ArrayAdapter<String> myAdapter3 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.year));
        myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner3.setAdapter(myAdapter3);
        mySpinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0)
                    years = "Firstyear";
                else if (i == 1)
                    years = "Secondyear";
                else if (i == 2)
                    years = "Thirdyear";
                else if (i == 3)
                    years = "Fourthyear";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner mySpinner4 = findViewById(R.id.spinner4);
        final ArrayAdapter<String> myAdapter4 = new ArrayAdapter<>(this,
            android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.department));
        myAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner4.setAdapter(myAdapter4);
        mySpinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                for (int h = 0; h <= i; h++)
                    departments = myAdapter4.getItem(h);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner mySpinner5 = findViewById(R.id.spinner5);
        final ArrayAdapter<String> myAdapter5 = new ArrayAdapter<>(this,
            android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.semestr));
        myAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner5.setAdapter(myAdapter5);
        mySpinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                for (int h = 0; h <= i; h++)
                    smesters = myAdapter5.getItem(h);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner mySpinner6 = findViewById(R.id.spinner6);
        final ArrayAdapter<String> myAdapter6 = new ArrayAdapter<>(this,
            android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.hall));
        myAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner6.setAdapter(myAdapter6);
        mySpinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                for (int h = 0; h <= i; h++)
                    holles = myAdapter6.getItem(h);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner mySpinner7 = findViewById(R.id.spinner7);
        final ArrayAdapter<String> myAdapter7 = new ArrayAdapter<>(this,
            android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.time));
        myAdapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner7.setAdapter(myAdapter7);
        mySpinner7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                for (int h = 0; h <= i; h++)
                    times = myAdapter7.getItem(h);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner mySpinner8 = findViewById(R.id.spinner8);
        final ArrayAdapter<String> myAdapter8 = new ArrayAdapter<>(this,
            android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.day));
        myAdapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner8.setAdapter(myAdapter8);
        mySpinner8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                for (int h = 0; h <= i; h++)
                    days = myAdapter8.getItem(h);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sent();
            }
        });
    }

    private void sent() {

        // URL To Fetch Data From The Server
        String LOGIN_URL = "https://gametyapp.000webhostapp.com/teacher_schedules.php?teacher_ID=" + teacher_ids + "&appointment=" + departments + "&leacture_hall=" + holles + "&semester_NO=" + smesters + "&course_ID=" + course_names + "&year=" + years + "&Time=" + times + "&day=" + days;

        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("success")) {
                    Toast.makeText(getApplicationContext(), "Sent Success", Toast.LENGTH_LONG).show();
                } else if (response.trim().equals("update")) {
                    Toast.makeText(getApplicationContext(), "update Successful", Toast.LENGTH_LONG).show();
                } else if (response.trim().equals("oops! Please try again!")) {
                    Toast.makeText(getApplicationContext(), "Error Send", Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), "No Internet Access", Toast.LENGTH_LONG).show();

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("teacher", teacher_ids);
                params.put("course", course_names);
                params.put("times", times);
                params.put("holles", holles);
                params.put("day", days);
                params.put("years", years);
                params.put("department", departments);
                params.put("smesters", smesters);
                return params;
            }
        };

        // Execute Requesting
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}