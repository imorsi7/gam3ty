package com.mahmoudreda.gamety;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class sign_in_data_base_sec extends AsyncTask<String, Void, String> {
    Context x;

    protected void onPreExecute() {

    }

    protected String doInBackground(String... arg0) {
        try {

            URL url = new URL("https://gamety.000webhostapp.com/signuptech.php?teacher_ID=" + arg0[0] + "&passcode=" + arg0[1]);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line;
            StringBuffer buffer = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                buffer.append(line + "\n");
                //2a2ra l7ad fen
            }

            return buffer.toString();
        } catch (Exception e) {
            return new String("Exception: " + e.getMessage());
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(x, result, Toast.LENGTH_LONG).show();
    }
}
