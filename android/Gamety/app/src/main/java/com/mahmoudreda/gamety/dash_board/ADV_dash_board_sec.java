package com.mahmoudreda.gamety.dash_board;

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

public class ADV_dash_board_sec extends AppCompatActivity {

    EditText post_title, post;
    String  bost_title,bost ;
    Button P;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adv_dash_board_sec);
        post_title = findViewById(R.id.editText_post_title);
        post = findViewById(R.id.editText_post);
        P = findViewById(R.id.Button_post);

        P.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bost_title = post_title.getText().toString();
                bost = post.getText().toString().trim();

                if (bost_title.isEmpty())
                    post_title.setError("Title Cannot be Empty");
                else if (bost.isEmpty()) {
                    post.setError("Description Cannot be Empty");
                }else  {
                    Toast.makeText(ADV_dash_board_sec.this, "Loading...", Toast.LENGTH_SHORT).show();
                    set_dash_board();
                }
            }
        });
    }

    private void set_dash_board() {

        // URL To Fetch Data From The Server
        String LOGIN_URL = "https://gamety.000webhostapp.com/announcement.php?title=" + bost_title + "&description=" + bost;

        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("post successful")) {
                    Toast.makeText(getApplicationContext(), "Post successful", Toast.LENGTH_SHORT).show();
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
                params.put("Boast_title", bost_title);
                params.put("Boast", bost);
                return params;
            }
        };

        // Execute Requesting
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}