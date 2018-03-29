package com.mahmoudreda.gamety;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sign_up extends Activity {

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

                if (first_name.length() >= 1 || middle_name.length() >= 1 || last_name.length() >= 1 || id_sign_up.length() >= 1 || email_sign_up.length() >= 1 || password_sign_up.length() >= 1) {
                    if (id_sign_up.length() == 8) {
                        sign_up_to_data_base my_data = new sign_up_to_data_base();
                        my_data.x = getApplicationContext();
                        my_data.execute(id_sign_up, first_name, middle_name, last_name, email_sign_up, password_sign_up);
                        Toast.makeText(Sign_up.this, "welcome student", Toast.LENGTH_LONG).show();
                    } else {
                        sign_up_to_data_base my_data = new sign_up_to_data_base();
                        my_data.x = getApplicationContext();
                        my_data.execute(id_sign_up, first_name, middle_name, last_name, email_sign_up, password_sign_up);
                    }
                } else

                {
                    Toast.makeText(Sign_up.this, "please inter your data ", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
