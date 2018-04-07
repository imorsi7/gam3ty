package com.mahmoudreda.gamety.sign_package;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mahmoudreda.gamety.MainActivity_secretary;
import com.mahmoudreda.gamety.MainActivity_student;
import com.mahmoudreda.gamety.R;
import com.mahmoudreda.gamety.course_content.upload_courses_content_doctor;

public class sign_in extends AppCompatActivity {

    EditText id, pass;
    Button logIn;
    String id_sign_in, password_sign_in, sec_id = "1010", sec_pass = "gamety admin";

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

                if (id_sign_in.isEmpty())
                    id.setError("ID Cannot be Empty");
                else if (password_sign_in.isEmpty()) {
                    pass.setError("The Password Cannot be Empty");
                    SharedPreferences sharedpreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("Name", id_sign_in);
                    editor.apply();
                } else if (id_sign_in.length() == 8) {
                    sign_in_data_base_stu my_data = new sign_in_data_base_stu();
                    my_data.x = getApplicationContext();
                    my_data.execute(id_sign_in, password_sign_in);
                    Intent i = new Intent(getApplicationContext(), MainActivity_student.class);
                    startActivity(i);
                    finish();
                    SharedPreferences sharedpreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("Name", id_sign_in);
                    editor.apply();

                    Toast.makeText(sign_in.this, "welcome student", Toast.LENGTH_LONG).show();
                } else if (id_sign_in.length() == 6) {
                    sign_in_data_base my_data = new sign_in_data_base();
                    my_data.x = getApplicationContext();
                    my_data.execute(id_sign_in, password_sign_in);
                    Intent i = new Intent(getApplicationContext(), upload_courses_content_doctor.class);
                    startActivity(i);

                    SharedPreferences sharedpreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("Name", id_sign_in);
                    editor.apply();
                    finish();

                    Toast.makeText(sign_in.this, "welcome Doctor", Toast.LENGTH_LONG).show();

                } else if (id_sign_in.length() == 4 && id_sign_in.equals(sec_id) && password_sign_in.equals(sec_pass)) {

                    Intent i = new Intent(getApplicationContext(), MainActivity_secretary.class);
                    startActivity(i);

                    SharedPreferences sharedpreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("Name", id_sign_in);
                    editor.apply();
                    finish();
                    Toast.makeText(sign_in.this, "welcome Secretary", Toast.LENGTH_LONG).show();
                } else
                    id.setError("ID is Exist");
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.login_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.exit) {
            //Alert Dialog In Click
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setMessage("Are You Sure Want Exit App")
                    .setIcon(R.drawable.ic_warning_black_24dp)
                    .setTitle("Exit Confirmation")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).show();
        }
        return super.onOptionsItemSelected(item);
    }

}
