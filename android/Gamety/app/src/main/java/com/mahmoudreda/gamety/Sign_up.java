package com.mahmoudreda.gamety;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Sign_up extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        final EditText x = findViewById(R.id.editText_first_name_sign_up);
        final EditText y = findViewById(R.id.editText_middle_name_sign_up);
        final EditText p = findViewById(R.id.editText_last_name_sign_up);
        final EditText w = findViewById(R.id.editText_id_sign_up);
        final EditText z = findViewById(R.id.editText_email_sign_up);
        final EditText g = findViewById(R.id.editText_password_sign_up);

        Button l = findViewById(R.id.button_sign_up_data);
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String first_name = x.getText().toString();
                final String second_name = y.getText().toString();
                final String last_name = p.getText().toString();
                final String id_sign_up = w.getText().toString();
                final String email_sign_up = z.getText().toString();
                final String password_sign_up = g.getText().toString();


                sign_up_to_data_base my_data=new sign_up_to_data_base();
                my_data.x=getApplicationContext();
                my_data.execute(first_name,second_name,last_name,id_sign_up,email_sign_up,password_sign_up);
                Intent i = new Intent(getApplicationContext(), sign_in.class);
                startActivity(i);
            }
        });
    }
}
