package com.mahmoudreda.gamety.sign_package;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class Sign_up extends AppCompatActivity {

    EditText x, y, p, w, z, g;
    Button l;
    String id_sign_up, first_name, middle_name, last_name, email_sign_up, password_sign_up;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        p = findViewById(R.id.editText_last_name_sign_up);
        x = findViewById(R.id.editText_first_name_sign_up);
        y = findViewById(R.id.editText_middle_name_sign_up);
        w = findViewById(R.id.editText_id_sign_up);
        z = findViewById(R.id.editText_email_sign_up);
        g = findViewById(R.id.editText_password_sign_up);

        l = findViewById(R.id.button_sign_up_data);

        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id_sign_up = w.getText().toString();
                first_name = x.getText().toString();
                middle_name = y.getText().toString();
                last_name = p.getText().toString();
                email_sign_up = z.getText().toString();
                password_sign_up = g.getText().toString();

                if (first_name.isEmpty())
                    x.setError("The Name Cannot be Empty");
                else if (middle_name.isEmpty())
                    y.setError("The Name Cannot be Empty");
                else if (last_name.isEmpty())
                    p.setError("The Name Cannot be Empty");
                else if (id_sign_up.isEmpty())
                    w.setError("The ID Cannot be Empty");
                else if (email_sign_up.isEmpty())
                    z.setError("The Email Cannot be Empty");
                else if (password_sign_up.isEmpty())
                    g.setError("The Password Cannot be Empty");
                else if (id_sign_up.length() == 8) {
                    Sign_up_student();
                    Toast.makeText(Sign_up.this, "Loading...", Toast.LENGTH_SHORT).show();
                } else if (id_sign_up.length() == 6) {
                    Sign_teacher();
                    Toast.makeText(Sign_up.this, "Loading...", Toast.LENGTH_SHORT).show();
                } else
                    w.setError("Please Enter Right ID");
            }
        });
    }

    // Method To Sign up doctor Data to DataBase
    private void Sign_teacher() {

        // URL To Fetch Data From The Server
        String LOGIN_URL = "https://gamety.000webhostapp.com/signuptech.php?teacher_ID=" + id_sign_up + "&first_name=" + first_name + "&middle_name=" + middle_name + "&last_name=" + last_name + "&email=" + email_sign_up + "&passcode=" + password_sign_up;

        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("successfully registered")) {
                    //Intent
                    Intent intent = new Intent(getApplicationContext(), sign_in.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "successfully registered", Toast.LENGTH_LONG).show();
                } else if (response.trim().equals("username or email already exist"))
                    w.setError("ID  OR Email already exist");
                else
                    Toast.makeText(getApplicationContext(), "Error Send", Toast.LENGTH_LONG).show();
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
                params.put("id", id_sign_up);
                params.put("first", first_name);
                params.put("middle", middle_name);
                params.put("last", last_name);
                params.put("Email", email_sign_up);
                params.put("password", password_sign_up);
                return params;
            }
        };

        // Execute Requesting
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    // Method To Sign up Student to Data DataBase
    private void Sign_up_student() {

        // URL To Fetch Data From The Server
        String LOGIN_URL = "https://gamety.000webhostapp.com/signupstu.php?student_ID=" + id_sign_up + "&first_name=" + first_name + "&middle_name=" + middle_name + "&last_name=" + last_name + "&email=" + email_sign_up + "&passcode=" + password_sign_up;

        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("successfully registered")) {
                    //Intent
                    Intent intent = new Intent(getApplicationContext(), sign_in.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "successfully registered", Toast.LENGTH_LONG).show();
                } else if (response.trim().equals("username or email already exist"))
                    w.setError("ID OR Email already exist");
                else
                    Toast.makeText(getApplicationContext(), "Error Send", Toast.LENGTH_LONG).show();
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
                params.put("id", id_sign_up);
                params.put("first", first_name);
                params.put("middle", middle_name);
                params.put("last", last_name);
                params.put("Email", email_sign_up);
                params.put("password", password_sign_up);
                return params;
            }
        };

        // Execute Requesting
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}