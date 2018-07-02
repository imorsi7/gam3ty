package com.mahmoudreda.gamety.dash_board;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
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

public class ADV_dash_board_sec_display_delete extends AppCompatActivity {
    ListView listView;
    String ID;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adv_dash_board_sec_display_delete);
        listView = findViewById(R.id.list_dash_sec);

        get_data();


    }

    // URL To Fetch Data From The Server
    private static final String GETURL = "https://gametyapp.000webhostapp.com/get.php";

    // Method To Get Chats The Data From DataBase
    public void get_data()

    {

        final ArrayList<item_Dash_Board> list_Item = new ArrayList<>();

        final JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, GETURL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                final MY_adapter adapter = new MY_adapter(getApplicationContext(), list_Item);
                listView.setAdapter(adapter);
                try {

                    for (int i = 0; i < response.length(); i++) {

                        JSONObject ob = response.getJSONObject(i);
                        adapter.notifyDataSetChanged();
                        item_Dash_Board object = new item_Dash_Board();
                        object.setTitle(ob.getString("title"));
                        object.setDesc(ob.getString("description"));
                        object.setid(ob.getString("announcement_ID"));
                        list_Item.add(object);

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

}