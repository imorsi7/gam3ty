package com.mahmoudreda.gamety.sign_package;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mahmoudreda.gamety.R;

public class Sign_up extends AppCompatActivity {

    EditText x, y, p, w, z, g;
    Button l;
    String id_sign_up, first_name, middle_name, last_name, email_sign_up, password_sign_up;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        p = findViewById(R.id.editText_last_name_sign_up);
        x = findViewById(R.id.editText_first_name_sign_up);
        y = findViewById(R.id.editText_middle_name_sign_up);
        w = findViewById(R.id.editText_id_sign_up);
        z = findViewById(R.id.editText_email_sign_up);
        g = findViewById(R.id.editText_password_sign_up);

        l = findViewById(R.id.button_sign_up_data);

        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id_sign_up = w.getText().toString();
                first_name = x.getText().toString();
                middle_name = y.getText().toString();
                last_name = p.getText().toString();
                email_sign_up = z.getText().toString();
                password_sign_up = g.getText().toString();

                if (first_name.length() >= 1 && middle_name.length() >= 1 && last_name.length() >= 1 && id_sign_up.length() >= 4 && email_sign_up.length() >= 1 && password_sign_up.length() >= 1) {
                    if (id_sign_up.length() == 8) {
                        sign_up_to_data_base_stu my_data = new sign_up_to_data_base_stu();
                        my_data.x = getApplicationContext();
                        my_data.execute(id_sign_up, first_name, middle_name, last_name, email_sign_up, password_sign_up);
                        Intent i = new Intent(getApplicationContext(), sign_in.class);
                        startActivity(i);
                        Toast.makeText(Sign_up.this, "welcome student", Toast.LENGTH_LONG).show();
                    } else if (id_sign_up.length() == 6) {
                        sign_up_to_data_base my_data = new sign_up_to_data_base();
                        my_data.x = getApplicationContext();
                        my_data.execute(id_sign_up, first_name, middle_name, last_name, email_sign_up, password_sign_up);
                        Intent i = new Intent(getApplicationContext(), sign_in.class);
                        startActivity(i);
                        Toast.makeText(Sign_up.this, "welcome Doctor", Toast.LENGTH_LONG).show();
                    } else if (id_sign_up.length() == 4) {
                        sign_up_to_data_base_sec my_data = new sign_up_to_data_base_sec();
                        my_data.x = getApplicationContext();
                        my_data.execute(id_sign_up, first_name, middle_name, last_name, email_sign_up, password_sign_up);
                        Intent i = new Intent(getApplicationContext(), sign_in.class);
                        startActivity(i);
                        Toast.makeText(Sign_up.this, "welcome secretary", Toast.LENGTH_LONG).show();
                    } else {

                        Toast.makeText(Sign_up.this, "Please Enter Right ID", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(Sign_up.this, "Please Enter your data ", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}