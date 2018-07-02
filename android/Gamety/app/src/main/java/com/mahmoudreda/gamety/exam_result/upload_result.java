package com.mahmoudreda.gamety.exam_result;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class upload_result extends AppCompatActivity {
    String years, departments, smesters, link;
    Button upload;
    EditText result_link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_result);

        upload = findViewById(R.id.button_upload_result);
        result_link = findViewById(R.id.editText_result_link);

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
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                link = result_link.getText().toString().trim();


                if (link.isEmpty())
                    result_link.setError("teacher name Cannot be Empty");
                else
                    sent();
            }
        });
    }

    private void sent() {

        // URL To Fetch Data From The Server
        String LOGIN_URL = "https://gametyapp.000webhostapp.com/result.php?link=" + link + "&semester_NO=" + smesters + "&a_year=" + years + "&department=" + departments;

        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("success")) {

                    Toast.makeText(getApplicationContext(), "upload Success", Toast.LENGTH_LONG).show();
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
                params.put("teacher", link);
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
