package com.mahmoudreda.gamety;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sign_in extends AppCompatActivity {

    EditText id, pass;
    Button logIn;
    String id_sign_in, password_sign_in;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        id = findViewById(R.id.editText_id_sign_in);
        pass = findViewById(R.id.editText_password_sign_in);
        logIn = findViewById(R.id.button_log_in);
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id_sign_in = id.getText().toString();
                password_sign_in = pass.getText().toString();

                if (id_sign_in.length() >= 1 || password_sign_in.length() >= 1) {
                    if (id_sign_in.length() == 8) {
                        sign_in_data_base_stu my_data = new sign_in_data_base_stu();
                        my_data.x = getApplicationContext();
                        my_data.execute(id_sign_in, password_sign_in);
                        Intent i = new Intent(getApplicationContext(),ADV_dash_board.class);
                        startActivity(i);

                        SharedPreferences sharedpreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString("id", id_sign_in);
                        editor.apply();
                        Toast.makeText(sign_in.this, "welcome student", Toast.LENGTH_LONG).show();
                    } else if (id_sign_in.length() == 6) {
                        sign_in_data_base my_data = new sign_in_data_base();
                        my_data.x = getApplicationContext();
                        my_data.execute(id_sign_in, password_sign_in);
                        Intent i = new Intent(getApplicationContext(), schedule.class);
                        startActivity(i);

                        SharedPreferences sharedpreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString("pass", id_sign_in);
                        editor.apply();

                        Toast.makeText(sign_in.this, "welcome Doctor", Toast.LENGTH_LONG).show();

                    } else if (id_sign_in.length() == 4) {
                        sign_in_data_base_sec my_data = new sign_in_data_base_sec();
                        my_data.x = getApplicationContext();
                        my_data.execute(id_sign_in, password_sign_in);
                        Intent i = new Intent(getApplicationContext(), ADV_dash_board_sec.class);
                        startActivity(i);

                        SharedPreferences sharedpreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString("Name", id_sign_in);
                        editor.apply();

                        Toast.makeText(sign_in.this, "welcome Secretary", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(sign_in.this, "Please Enter Right ID", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(sign_in.this, "please Enter your data ", Toast.LENGTH_LONG).show();
                    SharedPreferences sharedpreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("Name", id_sign_in);
                    editor.apply();
                }
            }
        });
    }
}
