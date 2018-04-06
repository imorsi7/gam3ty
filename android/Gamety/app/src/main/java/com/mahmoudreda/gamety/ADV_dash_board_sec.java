package com.mahmoudreda.gamety;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ADV_dash_board_sec extends AppCompatActivity {

    EditText post, post_title;
    String bost, bost_title,id="";
    Button P;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adv_dash_board_sec);
        post = findViewById(R.id.editText_post);
        post_title = findViewById(R.id.editText_post_title);
        P = findViewById(R.id.Button_post);
        P.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bost = post.getText().toString();
                bost_title = post_title.getText().toString();
                if (bost.length() >= 1 || bost_title.length() >= 1) {
                    dash_board_set_data my_data = new dash_board_set_data();
                    my_data.x = getApplicationContext();
                    my_data.execute(id,bost_title,bost);
                    Toast.makeText(ADV_dash_board_sec.this, "Loading....", Toast.LENGTH_LONG).show();
                } else
                    Toast.makeText(ADV_dash_board_sec.this, "Enter data first", Toast.LENGTH_LONG).show();
            }
        });

    }
}
