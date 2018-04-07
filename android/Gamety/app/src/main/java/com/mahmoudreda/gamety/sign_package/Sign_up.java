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

                if (first_name.isEmpty())
                    x.setError("The Name Cannot be Empty");
                else if (middle_name.isEmpty())
                    y.setError("The Name Cannot be Empty");
                else if (last_name.isEmpty())
                    p.setError("The Name Cannot be Empty");
                else if (id_sign_up.isEmpty())
                    w.setError("The ID Cannot be Empty");
                else if (email_sign_up.isEmpty())
                    z.setError("The Email Cannot be Empty");
                else if (password_sign_up.isEmpty())
                    g.setError("The Password Cannot be Empty");
                else if (id_sign_up.length() == 8) {
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
                } else {
                    w.setError("ID is Exist");
                }
            }
        });
    }

}