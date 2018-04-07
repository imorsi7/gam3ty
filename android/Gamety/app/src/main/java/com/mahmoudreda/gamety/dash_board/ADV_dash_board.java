package com.mahmoudreda.gamety.dash_board;

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

public class ADV_dash_board extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adv_dash_board);

        final ListView z = findViewById(R.id.list_dash_student);

      /*  dash_board_get_data my_data = new dash_board_get_data(z);
        my_data.k = getApplicationContext();
        my_data.execute();*/

        // URL To Fetch Data From The Server
        String GETURL = "https://gamety.000webhostapp.com/get.php";

        // private ArrayList<ItemChat> list = new ArrayList<ItemChat>();

        // Method To Get Chat The Data From DataBase

        final ArrayList<item_Dash_Board> list_Item = new ArrayList<>();

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, GETURL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {

                    for (int i = 0; i < response.length(); i++) {

                        JSONObject ob = response.getJSONObject(i);
                        item_Dash_Board object = new item_Dash_Board();
                        object.setTitle(ob.getString("announcement_title"));
                        object.setDesc(ob.getString("announcement_description"));
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

}



