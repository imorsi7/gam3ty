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

    public dash_board_get_data(ListView z)
    {
        l = z;
    }

    protected void onPreExecute() {

    }

    protected String doInBackground(Void... arg0) {
        try {
            URL url = new URL("http://192.168.1.7/android_chat/get.php");

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
        String Lines[]=result.split("<br/>");
        title =new String[Lines.length-1];
        description=new String[Lines.length-1];
        for (int i=0;i<Lines.length-1;i++)
        {
            String arr[]=Lines[i].split(",");
            title[i]=arr[0];
            description[i]=arr[1];
        }

        MY_adapter my_adapter = new MY_adapter(title, description);
        l.setAdapter(my_adapter);


    }
}

