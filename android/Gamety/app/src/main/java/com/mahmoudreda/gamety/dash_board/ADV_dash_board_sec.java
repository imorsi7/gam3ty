package com.mahmoudreda.gamety.dash_board;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mahmoudreda.gamety.R;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ADV_dash_board_sec extends AppCompatActivity {

    EditText post_title, post;
    String bost_title, bost;
    String result="";
    Button P;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adv_dash_board_sec);
        post_title = findViewById(R.id.editText_post_title);
        post = findViewById(R.id.editText_post);
        P = findViewById(R.id.Button_post);

        P.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bost_title = post_title.getText().toString();
                bost = post.getText().toString().trim();


                if (bost_title.isEmpty())
                    post_title.setError("Title Cannot be Empty");
                else if (bost.isEmpty()) {
                    post.setError("Description Cannot be Empty");
                } else {
                    Toast.makeText(ADV_dash_board_sec.this, "Loading...", Toast.LENGTH_SHORT).show();
                    //set_dash_board();
                     String temp="https://gametyapp.000webhostapp.com/announcement.php?title="+post_title.getText().toString()+"&description="+post.getText().toString();
                    temp = temp.replaceAll(" ", "%20");

                    new ADV_dash_board_sec.MyAsyncTaskresources().execute(temp);

                }
            }
        });
    }

    private void set_dash_board() {


/*
        // URL To Fetch Data From The Server
        String LOGIN_URL = "https://gametyapp.000webhostapp.com/announcement.php?title=" + bost_title + "&description=" + bost;

        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("post successful")) {
                    Toast.makeText(getApplicationContext(), "Post successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Error Send", Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "No Internet Access"+bost_title, Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("Boast_title", bost_title);
                params.put("Boast", bost);
                return params;
            }
        };

        // Execute Requesting
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        */
    }
    public class MyAsyncTaskresources extends AsyncTask<String, String, String>
    {
        @Override
        protected  void onPreExecute(){}

        @Override
        protected  String doInBackground(String... params)
        {
            InputStream isr=null;
            try
            {
                String URL=params[0];
                java.net.URL url= new URL(URL);
                URLConnection urlConnection=url.openConnection();
                isr =new BufferedInputStream(urlConnection.getInputStream());
            }
            catch (Exception e)
            {
                Log.e("log_tag","Error in http connection "+e.toString());
            }
            try
            {
                BufferedReader reader =new BufferedReader(new InputStreamReader(isr,"UTF-8"),8);
                StringBuilder br= new StringBuilder();
                String line =null;
                while ((line=reader.readLine())!=null)
                {
                    br.append(line);
                }
                isr.close();
                result=br.toString();
            }
            catch (Exception e)
            {
                Log.e("log_tag","Error Converting result "+e.toString());
            }
            return null;
        }

        protected void onPostExecute( String result2)
        {
            try
            {
                if(result.equals("post successful"))
                {
                    Toast.makeText(getApplicationContext(),"Post successful",Toast.LENGTH_LONG).show();

                }
                else
                    Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();

            }

            catch (Exception e)
            {
                Log.e("log_tag","Error "+e.toString());
            }

        }

    }
}