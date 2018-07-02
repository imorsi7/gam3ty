package com.mahmoudreda.gamety.toalbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.mahmoudreda.gamety.R;

public class qr extends AppCompatActivity {

    Button share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);

        share = findViewById(R.id.button_share);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text / plain");
                String sharebody = "\"Gamety App\"" +"https://play.google.com/store/apps/details?id=com.mahmoudreda.gamety";
                myIntent.putExtra(Intent.EXTRA_TEXT, sharebody);
                startActivity(Intent.createChooser(myIntent, "Share Gamety App using"));

            }
        });
    }
}
