package com.mahmoudreda.gamety.course_content;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mahmoudreda.gamety.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mahmoud reda on 01/06/2018.
 */

public class recycleadapter_doctor extends RecyclerView.Adapter<recycleadapter_doctor.ViewHolder>  {
    private ArrayList<list_item_sch_doctor> list = new ArrayList<>();
    public Context context;
   private String links ,coureses_name ;

    recycleadapter_doctor(ArrayList<list_item_sch_doctor> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view1 = inflater.inflate(R.layout.custmer_list_view_schedule_doctor, null);
        return new ViewHolder(view1);
    }

    @Override
    public void onBindViewHolder(final recycleadapter_doctor.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        // - replace the contents of the view with that element
        holder.coure_name.setText(list.get(position).getCourse_name());
        holder.year.setText(list.get(position).getYear());
        holder.day.setText(list.get(position).getDay());
        holder.time.setText(list.get(position).getTime());
        holder.hall.setText(list.get(position).getHall());
        holder.department.setText(list.get(position).getDepartment());
        holder.semester.setText(list.get(position).getSemester());
        holder.link.setText(list.get(position).getLink());



        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                links=holder.link.getText().toString();
                coureses_name=holder.coure_name.getText().toString();
                sent_link();
                return false;
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
        TextView time, hall, coure_name, day, year, department, semester;
        EditText link;

        ViewHolder(View itemView) {
            super(itemView);
            link = itemView.findViewById(R.id.course_link);
            coure_name = itemView.findViewById(R.id.course_name_doctor);
            year = itemView.findViewById(R.id.year_doctor);
            day = itemView.findViewById(R.id.day_doctor);
            time = itemView.findViewById(R.id.time_doctor);
            hall = itemView.findViewById(R.id.hall_doctor);
            department = itemView.findViewById(R.id.department_doctor);
            semester = itemView.findViewById(R.id.semester_doctor);

        }
    }
    private void sent_link() {

        // URL To Fetch Data From The Server
        String LOGIN_URL = "https://gametyapp.000webhostapp.com/course_link.php?course_ID=" + coureses_name + "&course_Link=" + links;

        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("post successful"))
                    Toast.makeText(context, "saved successfully", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(context, "error send", Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "No Internet Access", Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("course_name", coureses_name);
                params.put("link",links);
                return params;
            }
        };
        // Execute Requesting
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
}
