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
        EditText x = findViewById(R.id.editText_name_sign_up);
        EditText y = findViewById(R.id.editText_id_sign_up);
        EditText z = findViewById(R.id.editText_email_sign_up);
        EditText g = findViewById(R.id.editText_password_sign_up);
        EditText h = findViewById(R.id.editText_confirm_password);
        Button l = findViewById(R.id.button_sign_up_data);
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), schedule.class);
                startActivity(i);
            }
        });
    }
}
