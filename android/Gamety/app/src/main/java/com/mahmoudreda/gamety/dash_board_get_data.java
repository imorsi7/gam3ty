package com.mahmoudreda.gamety;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by mahmoud reda on 02/04/2018.
 */

public class dash_board_get_data extends AsyncTask<Void, Void, String> {
    Context k;
    String[] title;
    String[] description;
    ListView l;

    public dash_board_get_data(ListView z) {
        l = z;
    }

    protected void onPreExecute() {

    }

    protected String doInBackground(Void... arg0) {
        try {
            URL url = new URL("https://gamety.000webhostapp.com/get.php");

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
        String Lines[] = result.split(",");
        title = new String[Lines.length];
        description = new String[Lines.length];
        for (int i = 0; i < Lines.length; i++) {
            String arr[] = Lines[i].split(",");
            title[i] = arr[0];
            description[i] = arr[1];
        }

        MY_adapter my_adapter = new MY_adapter(title, description);
        l.setAdapter(my_adapter);


    }
}

