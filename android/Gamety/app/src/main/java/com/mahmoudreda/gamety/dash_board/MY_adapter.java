package com.mahmoudreda.gamety.dash_board;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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


@SuppressWarnings({"SuspiciousMethodCalls", "ControlFlowStatementWithoutBraces", "ConstantConditions"})
public class MY_adapter extends BaseAdapter {
    private Context c;
    private ArrayList<item_Dash_Board> list;


    MY_adapter(Context c, ArrayList<item_Dash_Board> list) {
        this.c = c;
        this.list = list;
    }

    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.indexOf(getItem(position));
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View view, ViewGroup group) {
        LayoutInflater inf = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null)
            view = inf.inflate(R.layout.customer_list_dash_student, null);
        TextView x = view.findViewById(R.id.title_customer);
        TextView y = view.findViewById(R.id.description_customer);
        final TextView f = view.findViewById(R.id.id_customer);
        x.setText(list.get(position).getTitle());
        y.setText(list.get(position).getDesc());
        f.setText(list.get(position).getid());

        y.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                delete_item(f.getText().toString().trim());
                return false;
            }
        });
        return view;
    }


    // Method To Sign up doctor Data to DataBase
    private void delete_item(final String id) {

        // URL To Fetch Data From The Server
        String LOGIN_URL = "https://gametyapp.000webhostapp.com/delete.php?announcement_ID=" + id;

        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("Delete successfully")) {
                    Toast.makeText(c, "Delete successfully" + id, Toast.LENGTH_LONG).show();
                } else if (response.trim().equals("oops! Please try again!"))
                    Toast.makeText(c, "oops! Please try again!", Toast.LENGTH_LONG).show();
                else if (response.trim().equals("ID Not found"))
                    Toast.makeText(c, "ID Not found", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(c, "Error Send", Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(c, "No Internet Access", Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("id", id);
                return params;
            }
        };

        // Execute Requesting
        RequestQueue requestQueue = Volley.newRequestQueue(c);
        requestQueue.add(stringRequest);
    }
}
