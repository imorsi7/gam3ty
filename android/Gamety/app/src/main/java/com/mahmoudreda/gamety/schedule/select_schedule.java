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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mahmoudreda.gamety.R;

import java.util.HashMap;
import java.util.Map;

public class select_schedule extends AppCompatActivity {
    EditText teacher_name;
    String teacher_names, course_names, times, holles, days, years, departments, smesters;
    Button upload;
    // final ArrayList<String> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_schedule);

        //x();
        upload = findViewById(R.id.button_upload_schedule);

        teacher_name = findViewById(R.id.EditText_teacher_name);

        Spinner mySpinner = findViewById(R.id.spinner1);
        final ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this,
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
        final ArrayAdapter<String> myAdapter2 = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.department));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner2.setAdapter(myAdapter2);
        mySpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                for (int h = 0; h <= i; h++)
                    departments = myAdapter2.getItem(h);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner mySpinner3 = findViewById(R.id.spinner3);
        final ArrayAdapter<String> myAdapter3 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.semestr));
        myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner3.setAdapter(myAdapter3);
        mySpinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                for (int h = 0; h <= i; h++)
                    smesters = myAdapter3.getItem(h);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner mySpinner4 = findViewById(R.id.spinner4);
        final ArrayAdapter<String> myAdapter4 = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.day));
        myAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner4.setAdapter(myAdapter4);
        mySpinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                for (int h = 0; h <= i; h++)
                    days = myAdapter4.getItem(h);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner mySpinner5 = findViewById(R.id.spinner5);
        final ArrayAdapter<String> myAdapter5 = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.time));
        myAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner5.setAdapter(myAdapter5);
        mySpinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                for (int h = 0; h <= i; h++)
                    times = myAdapter5.getItem(h);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner mySpinner6 = findViewById(R.id.spinner6);
        final ArrayAdapter<String> myAdapter6 = new ArrayAdapter<>(this,
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
                else if (i == 8)
                    course_names = "free";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner mySpinner7 = findViewById(R.id.spinner7);
        final ArrayAdapter<String> myAdapter7 = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.hall));
        myAdapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner7.setAdapter(myAdapter7);
        mySpinner7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                for (int h = 0; h <= i; h++)
                    holles = myAdapter7.getItem(h);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teacher_names = teacher_name.getText().toString().trim();


                if (teacher_names.isEmpty())
                    teacher_name.setError("teacher name Cannot be Empty");
                else
                    sent();
            }
        });
    }

    private void sent() {

        // URL To Fetch Data From The Server
        String LOGIN_URL = "https://gametyapp.000webhostapp.com/schedual.php?appointment=" + times + "&teacher_name=" + teacher_names + "&leacture_hall=" + holles + "&semester_NO=" + smesters + "&course_ID=" + course_names + "&year=" + years + "&department=" + departments + "&day=" + days;

        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("success")) {

                    Toast.makeText(getApplicationContext(), "insert Successful", Toast.LENGTH_LONG).show();
                } else if (response.trim().equals("update"))
                {
                    Toast.makeText(getApplicationContext(), "update Successful", Toast.LENGTH_LONG).show();
                }
                else if (response.trim().equals("oops! Please try again!")){
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

    /*private void x() {
        // URL To Fetch Data From The Server
        String GETURL = "https://gametyapp.000webhostapp.com/hall.php";

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

    }*/
}
/*Spinner mySpinner5 = findViewById(R.id.spinner5);
        final ArrayAdapter<String> myAdapter5 = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, list);
        myAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner5.setAdapter(myAdapter5);
        mySpinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                for (int h = 0; h <= i; h++)
                    times = myAdapter5.getItem(h);
                Toast.makeText(getApplicationContext(), "hhh" + times, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/