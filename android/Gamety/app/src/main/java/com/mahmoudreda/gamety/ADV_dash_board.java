package com.mahmoudreda.gamety;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class ADV_dash_board extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adv_dash_board);

        ListView z = findViewById(R.id.list_dash_student);

        dash_board_get_data my_data = new dash_board_get_data(z);
        my_data.k = getApplicationContext();
        my_data.execute();

    }

}

