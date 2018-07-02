package com.mahmoudreda.gamety.course_content;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.mahmoudreda.gamety.R;
import com.mahmoudreda.gamety.schedule.alarm;
import com.mahmoudreda.gamety.toalbar.about_app;
import com.mahmoudreda.gamety.profile.profile_doc;
import com.mahmoudreda.gamety.toalbar.qr;
import com.mahmoudreda.gamety.sign_package.sign_in;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class upload_courses_content_doctor extends AppCompatActivity {
    String id;
    final ArrayList<list_item_sch_doctor> Item = new ArrayList<>();
    RecyclerView list_schedule_doctor;
    EditText link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_courses_content_doctor);

        link = findViewById(R.id.course_link);
        list_schedule_doctor = findViewById(R.id.list_schedule_doctor);
        list_schedule_doctor.setHasFixedSize(true);
        list_schedule_doctor.setLayoutManager(new LinearLayoutManager(this));


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), alarm.class);
                startActivity(i);
            }
        });

        SharedPreferences sharedpreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        id = sharedpreferences.getString("Name", null); // getting String;

        // URL To Fetch Data From The Server
        String GETURL = "https://gametyapp.000webhostapp.com/view.teacher_sc.php?teacher_ID=" + id;

        // Method To Get  The Data From DataBase

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, GETURL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {

                    for (int i = 0; i < response.length(); i++) {

                        JSONObject ob = response.getJSONObject(i);
                        list_item_sch_doctor object = new list_item_sch_doctor(ob.getString("course_name"),
                            ob.getString("year"), ob.getString("leacture_hall"),
                            ob.getString("day"), ob.getString("Time"), ob.getString("appointment"),
                            ob.getString("semester_NO"), ob.getString("course_Link"));

                        object.setCourse_name(ob.getString("course_name"));
                        object.setYear(ob.getString("year"));
                        object.setHall(ob.getString("leacture_hall"));
                        object.setDay(ob.getString("day"));
                        object.setTime(ob.getString("Time"));
                        object.setDepartment(ob.getString("appointment"));
                        object.setSemester(ob.getString("semester_NO"));
                        object.setLink(ob.getString("course_Link"));

                        Item.add(object);

                    }

                    final recycleadapter_doctor adapter = new recycleadapter_doctor(Item, getApplicationContext());
                    list_schedule_doctor.setAdapter(adapter);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation_doctor, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.profile_doctor:
                Intent intent3 = new Intent(upload_courses_content_doctor.this, profile_doc.class);
                startActivity(intent3);
                break;
            case R.id.share_app:
                Intent intent5 = new Intent(upload_courses_content_doctor.this, qr.class);
                startActivity(intent5);
                break;
            case R.id.about_app:
                Intent intent6 = new Intent(upload_courses_content_doctor.this, about_app.class);
                startActivity(intent6);
                break;
            case R.id.Log_out:
                Toast.makeText(this, "log out", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(upload_courses_content_doctor.this, sign_in.class);
                startActivity(intent1);
                SharedPreferences sharedpreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("Name", null);
                editor.apply();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
