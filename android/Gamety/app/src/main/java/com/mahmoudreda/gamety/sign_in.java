package com.mahmoudreda.gamety;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sign_in extends Activity {

    EditText x, y;
    Button l;
    String id_sign_in, password_sign_in;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        x = findViewById(R.id.editText_id_sign_in);
        y = findViewById(R.id.editText_password_sign_in);
        l = findViewById(R.id.button_log_in);
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id_sign_in = x.getText().toString();
                password_sign_in = y.getText().toString();


                if (id_sign_in.length() >= 1 || password_sign_in.length() >= 1) {
                    if (id_sign_in.length() == 8) {
                        sign_in_data_base my_data = new sign_in_data_base();
                        my_data.x = getApplicationContext();
                        my_data.execute(id_sign_in, password_sign_in);
                        Intent i = new Intent(getApplicationContext(), schedule.class);
                        startActivity(i);
                        SharedPreferences sharedpreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString("Name", id_sign_in);
                        editor.commit();

                        Toast.makeText(sign_in.this, "welcome student", Toast.LENGTH_LONG).show();

                    } else {
                        sign_in_data_base my_data = new sign_in_data_base();
                        my_data.x = getApplicationContext();
                        my_data.execute(id_sign_in, password_sign_in);
                        Intent i = new Intent(getApplicationContext(), Start.class);
                        startActivity(i);
                    }
                } else

                {
                    Toast.makeText(sign_in.this, "please inter your data ", Toast.LENGTH_LONG).show();
                    SharedPreferences sharedpreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("Name", id_sign_in);
                    editor.commit();
                }
            }
        });
    }
}
