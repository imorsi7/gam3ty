package com.mahmoudreda.gamety.schedule;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by mahmoud reda on 06/06/2018.
 */

@SuppressWarnings("DefaultFileTemplate")
public class My_alarm extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String state = intent.getExtras().getString("extra");
        Log.e("MyActivity", "In the receiver with " + state);

        Intent serviceIntent = new Intent(context, RingtonePlayingService.class);
        serviceIntent.putExtra("extra", state);

        context.startService(serviceIntent);
    }
}
