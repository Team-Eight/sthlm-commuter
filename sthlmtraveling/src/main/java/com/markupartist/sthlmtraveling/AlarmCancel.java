package com.markupartist.sthlmtraveling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.Toast;

public class AlarmCancel extends BroadcastReceiver{

    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Hold tight Asznee", Toast.LENGTH_LONG).show();
        Vibrator vibrator = (Vibrator) context.getSystemService(context.VIBRATOR_SERVICE);
        vibrator.vibrate(5000);

    }
}