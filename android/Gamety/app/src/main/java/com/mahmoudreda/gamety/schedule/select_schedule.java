package com.mahmoudreda.gamety.schedule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mahmoudreda.gamety.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class select_schedule extends AppCompatActivity {
    EditText teacher_name, holle;
    String teacher_names, course_names, times, holles, days, years, departments, smesters;
    Button upload;
    final ArrayList<String> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_schedule);

        x();
        upload = findViewById(R.id.button_upload_schedule);

        teacher_name = findViewById(R.id.EditText_teacher_name);
        holle = findViewById(R.id.EditeText_holle);

        Spinner mySpinner = findViewById(R.id.spinner1);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.year));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        Spinner mySpinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.department));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner2.setAdapter(myAdapter2);
        mySpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0)
                    departments = "General";
                else if (i == 1)
                    departments = "CS";
                else if (i == 2)
                    departments = "IS";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner mySpinner3 = findViewById(R.id.spinner3);
        ArrayAdapter<String> myAdapter3 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.semestr));
        myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner3.setAdapter(myAdapter3);
        mySpinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0)
                    smesters = "1";
                else if (i == 1)
                    smesters = "2";
                else if (i == 2)
                    smesters = "3";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner mySpinner4 = findViewById(R.id.spinner4);
        ArrayAdapter<String> myAdapter4 = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.day));
        myAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner4.setAdapter(myAdapter4);
        mySpinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0)
                    days = "sunday";
                else if (i == 1)
                    days = "monday";
                else if (i == 2)
                    days = "thursday";
                else if (i == 3)
                    days = "wednesday";
                else if (i == 4)
                    days = "thursday";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner mySpinner5 = findViewById(R.id.spinner5);
        ArrayAdapter<String> myAdapter5 = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, list);
        myAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner5.setAdapter(myAdapter5);
        mySpinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                //String x[] = getResources().getStringArray(R.array.time);

                times =adapterView.getSelectedView().toString();

                Toast.makeText(select_schedule.this, times, Toast.LENGTH_SHORT).show();
                    //times = x[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner mySpinner6 = findViewById(R.id.spinner6);
        ArrayAdapter<String> myAdapter6 = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.course_name));
        myAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner6.setAdapter(myAdapter6);
        mySpinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(select_schedule.this, times, Toast.LENGTH_SHORT).show();
                teacher_names = teacher_name.getText().toString().trim();
                holles = holle.getText().toString().trim();


                if (teacher_names.isEmpty())
                    teacher_name.setError("teacher name Cannot be Empty");
                else if (holles.isEmpty())
                    holle.setError("hall Cannot be Empty");
                else
                    sent();
            }
        });
    }

    private void sent() {

        // URL To Fetch Data From The Server
        String LOGIN_URL = "https://gamety.000webhostapp.com/schedual.php?appointment=" + times + "&teacher_name=" + teacher_names + "&leacture_hall=" + holles + "&semester_NO=" + smesters + "&course_ID=" + course_names + "&year=" + years + "&department=" + departments + "&day=" + days;

        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("success")) {

                    Toast.makeText(getApplicationContext(), "Sent Success", Toast.LENGTH_LONG).show();
                } else {
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
                params.put("teacher", teacher_names);
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

    private void x() {
        // URL To Fetch Data From The Server
        String GETURL = "https://gamety.000webhostapp.com/hall.php";

        // Method To Get Chat The Data From DataBase

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, GETURL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {

                    for (int i = 0; i < response.length(); i++) {

                        JSONObject ob = response.getJSONObject(i);
                        list.add(ob.getString("hall_No"));

                    }



                } catch (JSONException e) {

                    Toast.makeText(getApplicationContext(), "Problem in Server", Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "No Internet Access", Toast.LENGTH_LONG).show();
            }
        });

        // Execute Requesting
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);

    }
}