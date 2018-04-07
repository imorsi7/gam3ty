package com.mahmoudreda.gamety.dash_board;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class dash_board_set_data extends AsyncTask<String, Void, String> {
    Context x;

    protected void onPreExecute() {

    }

    protected String doInBackground(String... arg0) {
        try {
            /*announcement_ID="+arg0[0]+"*/
            URL url = new URL("https://gamety.000webhostapp.com/announcement.php?announcement_title=" + arg0[1] + "&announcement_description=" + arg0[2]);

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
