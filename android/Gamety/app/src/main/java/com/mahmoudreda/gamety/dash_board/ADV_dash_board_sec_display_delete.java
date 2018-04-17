package com.mahmoudreda.gamety.dash_board;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ADV_dash_board_sec_display_delete extends AppCompatActivity {

    ListView z;
    String K;
    TextView h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adv_dash_board_sec_display_delete);
        z = findViewById(R.id.list_dash_sec);

        get_data();

        // When Long Click Chat Item Displayed Dialog Pop Up To Order Deleting Chat Or Not
        z.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
              /*  AlertDialog.Builder  builder = new AlertDialog.Builder(getApplicationContext());
                builder.setMessage("Are You Sure Want Delete This Chat")
                        .setIcon(R.drawable.ic_warning_black_24dp)
                        .setTitle("Delete Confirmation")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Items.remove(which); In DataBase Only becuse This Array Static Not Daynamic
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // AnyThink Here Negative Button
                    }
                }).show();*/
                h = view.findViewById(R.id.id_customer);
                K = h.getText().toString();
                delete_item();
                //Toast.makeText(getApplicationContext(), "No Internet Access"+K, Toast.LENGTH_LONG).show();

                return false;
            }
        });
    }

    // URL To Fetch Data From The Server
    private static final String GETURL = "https://gamety.000webhostapp.com/get.php";

    // Method To Get Chats The Data From DataBase
    public void get_data()

    {

        final ArrayList<item_Dash_Board> list_Item = new ArrayList<>();

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, GETURL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {

                    for (int i = 0; i < response.length(); i++) {

                        JSONObject ob = response.getJSONObject(i);
                        item_Dash_Board object = new item_Dash_Board();
                        object.setTitle(ob.getString("title"));
                        object.setDesc(ob.getString("description"));
                        object.setid(ob.getString("announcement_ID"));
                        list_Item.add(object);

                    }

                    final MY_adapter adapter = new MY_adapter(getApplicationContext(), list_Item);
                    z.setAdapter(adapter);

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

    // Method To Sign up doctor Data to DataBase
    private void delete_item() {

        // URL To Fetch Data From The Server
        String LOGIN_URL = "https://gamety.000webhostapp.com/delete.php?announcement_ID=" + K;

        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("Delete successfully")) {
                    Toast.makeText(getApplicationContext(), "Delete successfully", Toast.LENGTH_LONG).show();
                } else if (response.trim().equals("oops! Please try again!"))
                    Toast.makeText(getApplicationContext(), "oops! Please try again!", Toast.LENGTH_LONG).show();
                else if (response.trim().equals("ID Not found"))
                    Toast.makeText(getApplicationContext(), "ID Not found", Toast.LENGTH_LONG).show();
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
                params.put("id", K);
                return params;
            }
        };

        // Execute Requesting
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}