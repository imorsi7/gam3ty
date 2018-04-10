package com.mahmoudreda.gamety.schedule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mahmoudreda.gamety.R;

import java.util.HashMap;
import java.util.Map;

public class select_schedule extends AppCompatActivity {
    EditText period, teacher_name, course_name, time, holle, day;
    String periods, teacher_names, course_names, times, holles, days, radioButton_1s, radioButton_2s, radioButton_3s;
    Button upload;
    RadioGroup radioGroup_1, radioGroup_2, radioGroup_3;
    RadioButton radioButton_1, radioButton_2, radioButton_3;
    int radioId_1, radioId_2, radioId_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_schedule);

        upload = findViewById(R.id.button_upload_schedule);

        period = findViewById(R.id.EditText_period);
        teacher_name = findViewById(R.id.EditText_teacher_name);
        course_name = findViewById(R.id.EditText_course_name);
        time = findViewById(R.id.EditText_time);
        holle = findViewById(R.id.EditeText_holle);
        day = findViewById(R.id.EditText_day);

        radioGroup_1 = findViewById(R.id.radioGroup_1);
        radioGroup_2 = findViewById(R.id.radioGroup_2);
        radioGroup_3 = findViewById(R.id.radioGroup_3);


        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                days = day.getText().toString().trim();
                periods = period.getText().toString().trim();
                teacher_names = teacher_name.getText().toString().trim();
                course_names = course_name.getText().toString().trim();
                times = time.getText().toString().trim();
                holles = holle.getText().toString().trim();

                radioId_1 = radioGroup_1.getCheckedRadioButtonId();
                radioId_2 = radioGroup_2.getCheckedRadioButtonId();
                radioId_3 = radioGroup_3.getCheckedRadioButtonId();

                radioButton_1 = findViewById(radioId_1);
                radioButton_2 = findViewById(radioId_2);
                radioButton_3 = findViewById(radioId_3);

                radioButton_1s = (String) radioButton_1.getText();
                radioButton_2s = (String) radioButton_2.getText();
                radioButton_3s = (String) radioButton_3.getText();

                if (days.isEmpty())
                    day.setError("period Cannot be Empty");
                else if (periods.isEmpty())
                    period.setError("period Cannot be Empty");
                else if (teacher_names.isEmpty())
                    teacher_name.setError("teacher name Cannot be Empty");
                else if (course_names.isEmpty())
                    period.setError("course name Cannot be Empty");
                else if (times.isEmpty())
                    time.setError("time Cannot be Empty");
                else if (holles.isEmpty())
                    holle.setError("hall Cannot be Empty");
                else
                    sent();
            }
        });
    }

    private void sent() {

        // URL To Fetch Data From The Server
        String LOGIN_URL = "https://gamety.000webhostapp.com/schedual.php?appointment=" + times + "&teacher_name=" + teacher_names + "&leacture_hall=" + holles + "&semester_NO=" + radioButton_3s + "&course_ID=" + course_names + "&year=" + radioButton_1s + "&department=" + radioButton_2s + "&day=" + days + "&period=" + periods;

        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("success")) {

                    Toast.makeText(getApplicationContext(), "Sent Success", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Error Send", Toast.LENGTH_LONG).show();
                }
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
                params.put("periods", periods);
                params.put("teacher", teacher_names);
                params.put("course", course_names);
                params.put("times", times);
                params.put("holles", holles);
                params.put("day", days);
                params.put("radio1", radioButton_1s);
                params.put("radio2", radioButton_2s);
                params.put("radio3", radioButton_3s);
                return params;
            }
        };

        // Execute Requesting
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}