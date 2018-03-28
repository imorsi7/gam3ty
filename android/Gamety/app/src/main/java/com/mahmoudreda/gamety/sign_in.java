package com.mahmoudreda.gamety;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class sign_in extends Activity {

    EditText x ,y;
    Button l;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        x=findViewById(R.id.editText_email_sign_in);
        y=findViewById(R.id.editText_password_sign_in);
        l=findViewById(R.id.button_log_in);

    }
}
