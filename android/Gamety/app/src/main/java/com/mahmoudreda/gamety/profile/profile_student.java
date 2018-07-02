package com.mahmoudreda.gamety.profile;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

public class profile_student extends AppCompatActivity {
    TextView n1, n2, n3, m, y, d;
    EditText password_new, old_pasword, pasword_new_2;
    Button change_password;
    String id, password, old_password, password_new_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_student);

        n1 = findViewById(R.id.frist_name_stu);
        n2 = findViewById(R.id.scound_name_stu);
        n3 = findViewById(R.id.last_name_stu);
        m = findViewById(R.id.mail_stu);
        y = findViewById(R.id.year_stu);
        d = findViewById(R.id.departmen_stu);
        password_new = findViewById(R.id.new_pass_stu);
        change_password = findViewById(R.id.button_new_password);
        old_pasword = findViewById(R.id.old_pass_stu);
        pasword_new_2 =findViewById(R.id.new_pass_stu_2);

        SharedPreferences sharedpreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        id = sharedpreferences.getString("Name", null); // getting String;

        get_data();

        change_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password = password_new.getText().toString().trim();
                old_password =old_pasword.getText().toString().trim();
                password_new_2 =pasword_new_2.getText().toString().trim();

                if (old_password.isEmpty())
                    old_pasword.setError("Please Write Your New Password ");
                else if (password.isEmpty())
                password_new.setError("Please Write Your Old Password");
                else if (password_new_2.isEmpty())
                    pasword_new_2.setError("Please Re Write Your New Password");
                else if (password.equals(password_new_2))
                change_password();
                else
                    pasword_new_2.setError("Not equal new password");

            }
        });

    }

    private void get_data() {

        // URL To Fetch Data From The Server
        String GETURL = "https://gametyapp.000webhostapp.com/userdata_student.php?id=" + id;

        // Method To Get Chat The Data From DataBase

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, GETURL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {

                    for (int i = 0; i < response.length(); i++) {

                        JSONObject ob = response.getJSONObject(i);

                        n1.setText(ob.getString("first_name"));
                        n2.setText(ob.getString("middle_name"));
                        n3.setText(ob.getString("last_name"));
                        m.setText(ob.getString("email"));
                        y.setText(ob.getString("Std_Year"));
                        d.setText(ob.getString("Std_dep"));

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

    private void change_password() {

        // URL To Fetch Data From The Server
        String LOGIN_URL = "https://gametyapp.000webhostapp.com/change_password_stu.php?student_ID=" + id + "&newpass=" + password + "&passcode=" + old_password;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("post successful")) {
                    Toast.makeText(getApplicationContext(), "Password changed", Toast.LENGTH_LONG).show();
                } else
                    old_pasword.setError("Wrong Password ");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "No Internet Access", Toast.LENGTH_LONG).show();
            }
        }) {
        };

        // Execute Requesting
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
