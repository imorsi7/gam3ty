package com.mahmoudreda.gamety.schedule;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ListView a = findViewById(R.id.list_schedule);

        SharedPreferences sharedpreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        id = sharedpreferences.getString("Name", null); // getting String;

        // URL To Fetch Data From The Server
        String GETURL = "https://gamety.000webhostapp.com/tableview.php?id="+id;

        // Method To Get Chat The Data From DataBase

        final ArrayList<item_schedule> list_Item = new ArrayList<>();

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, GETURL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {

                    for (int i = 0; i < response.length(); i++) {

                        JSONObject ob = response.getJSONObject(i);
                        item_schedule object = new item_schedule();
                        object.setTime(ob.getString("appointment"));
                        object.setTeacher_name(ob.getString("teacher_name"));
                        object.setHall(ob.getString("leacture_hall"));
                        object.setCourse_name(ob.getString("course_ID"));
                        object.setDay(ob.getString("day"));
                        list_Item.add(object);

                    }

                    final MY_adapter_view adapter = new MY_adapter_view(getApplicationContext(), list_Item);
                    a.setAdapter(adapter);

                } catch (JSONException e) {

                    Toast.makeText(getApplicationContext(), "Problem in Server", Toast.LENGTH_LONG).show();
                }
            }
        },new Response.ErrorListener() {
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