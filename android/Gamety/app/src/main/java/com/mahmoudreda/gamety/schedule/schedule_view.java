package com.mahmoudreda.gamety.schedule;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.mahmoudreda.gamety.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class schedule_view extends AppCompatActivity {

    String id;
    final ArrayList<list_Item_sch> Item = new ArrayList<>();
    RecyclerView list_schedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        list_schedule = findViewById(R.id.list_schedule);
        list_schedule.setHasFixedSize(true);
        list_schedule.setLayoutManager(new LinearLayoutManager(this));

        SharedPreferences sharedpreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        id = sharedpreferences.getString("Name", null); // getting String;

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), alarm.class);
                startActivity(i);
            }
        });

        get_data();

    }

    private void get_data() {

        // URL To Fetch Data From The Server
        String GETURL = "https://gametyapp.000webhostapp.com/tableview.php?id=" + id;

        // Method To Get Chat The Data From DataBase

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, GETURL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {

                    for (int i = 0; i < response.length(); i++) {

                        JSONObject ob = response.getJSONObject(i);
                        list_Item_sch object = new list_Item_sch(ob.getString("appointment"),
                                ob.getString("teacher_name"), ob.getString("leacture_hall"),
                                ob.getString("course_name"), ob.getString("day"));
                        object.setTime(ob.getString("appointment"));
                        object.setTeacher_name(ob.getString("teacher_name"));
                        object.setHall(ob.getString("leacture_hall"));
                        object.setCourse_name(ob.getString("course_name"));
                        object.setDay(ob.getString("day"));
                        Item.add(object);

                    }

                    final recycleadapter adapter = new recycleadapter(Item, getApplicationContext());
                    list_schedule.setAdapter(adapter);

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