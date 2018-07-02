package com.mahmoudreda.gamety.course_content;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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

public class course_content_student extends AppCompatActivity {
    String id;
    final ArrayList<list_item_course_student> Item = new ArrayList<>();
    RecyclerView list_schedule_student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_content_student);

        list_schedule_student = findViewById(R.id.list_course_student);
        list_schedule_student.setHasFixedSize(true);
        list_schedule_student.setLayoutManager(new LinearLayoutManager(this));
        SharedPreferences sharedpreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        id = sharedpreferences.getString("Name", null); // getting String;

        // URL To Fetch Data From The Server
        String GETURL = "https://gametyapp.000webhostapp.com/view_course_link.php?id=" + id;

        // Method To Get Chat The Data From DataBase

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, GETURL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {

                    for (int i = 0; i < response.length(); i++) {

                        JSONObject ob = response.getJSONObject(i);
                        list_item_course_student object = new list_item_course_student(
                            ob.getString("course_name"),
                            ob.getString("course_Link"));

                        object.setCourse_name_student(ob.getString("course_name"));
                        object.setLink_student(ob.getString("course_Link"));

                        Item.add(object);

                    }

                    final recycleadapter_student adapter = new recycleadapter_student(Item, getApplicationContext());
                    list_schedule_student.setAdapter(adapter);







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

    public class recycleadapter_student extends RecyclerView.Adapter<com.mahmoudreda.gamety.course_content.recycleadapter_student.ViewHolder> {
        private ArrayList<list_item_course_student> list = new ArrayList<>();
        public Context context;

        recycleadapter_student(ArrayList<list_item_course_student> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @Override
        public com.mahmoudreda.gamety.course_content.recycleadapter_student.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater inflater = LayoutInflater.from(context);
            View view1 = inflater.inflate(R.layout.customer_list_course_link_student, null);

            return new com.mahmoudreda.gamety.course_content.recycleadapter_student.ViewHolder(view1);
        }

        @Override
        public void onBindViewHolder(final com.mahmoudreda.gamety.course_content.recycleadapter_student.ViewHolder holder, final int position) {
            // - replace the contents of the view with that element
            holder.coure_name.setText(list.get(position).getCourse_name_student());
            holder.link.setText(list.get(position).getLink_student());

            holder.link.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(list.get(position).getLink_student())));
                }
            });

        }


        // Return the size of your database (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return list.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            TextView coure_name, link;

            ViewHolder(View itemView) {
                super(itemView);
                link = itemView.findViewById(R.id.link_student);
                coure_name = itemView.findViewById(R.id.course_name_student);




            }
        }
    }

}
