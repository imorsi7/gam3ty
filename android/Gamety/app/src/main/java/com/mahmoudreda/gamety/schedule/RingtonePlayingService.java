package com.mahmoudreda.gamety.schedule;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.mahmoudreda.gamety.R;

import java.util.Random;

public class RingtonePlayingService extends Service {

    private boolean isRunning;
    private Context context;
    private int startId;
    Uri h;
    Ringtone y;
    Vibrator v;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("MyActivity", "In the Richard service");
        return null;
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        final NotificationManager mNM = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);

        Intent intent1 = new Intent(this.getApplicationContext(), schedule_view.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent1, 0);

        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("Gamety");
        builder.setContentText("You have lecture" + "!");
        builder.setSmallIcon(R.drawable.time);
        builder.setContentIntent(pIntent);
        builder.setAutoCancel(true);
        //Vibrator v;
        Notification mNotify = builder.build();

        String state = intent.getExtras().getString("extra");
        h = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        y = RingtoneManager.getRingtone(getApplicationContext(), h);
        // v= (Vibrator) context.getSystemService(VIBRATOR_SERVICE);
        //v.vibrate(10000);
        Log.e("what is going on here  ", state);

        assert state != null;
        switch (state) {
            case "no":
                startId = 0;
                break;
            case "yes":
                startId = 1;
                break;
            default:
                startId = 0;
                break;
        }


        if (!this.isRunning && startId == 1) {
            Log.e("if there was not sound ", " and you want start");

            int min = 1;
            int max = 9;

            Random r = new Random();
            int random_number = r.nextInt(max - min + 1) + min;
            Log.e("random number is ", String.valueOf(random_number));
            for (int i = 1; i <= random_number; i++) {
                if (random_number == i)
                    y.play();
                else
                    y.play();
            }
            mNM.notify(0, mNotify);

            this.isRunning = true;
            this.startId = 0;

        } else if (!this.isRunning && startId == 0) {
            Log.e("if there was not sound ", " and you want end");

            this.isRunning = false;
            this.startId = 0;

        } else if (this.isRunning && startId == 1) {
            Log.e("if there is sound ", " and you want start");

            this.isRunning = true;
            this.startId = 0;

        } else {
            Log.e("if there is sound ", " and you want end");

            y.stop();

            this.isRunning = false;
            this.startId = 0;
        }


        Log.e("MyActivity", "In the service");

        return START_NOT_STICKY;

    }


    @Override
    public void onDestroy() {
        Log.e("JSLog", "on destroy called");
        super.onDestroy();

        this.isRunning = false;
    }


}