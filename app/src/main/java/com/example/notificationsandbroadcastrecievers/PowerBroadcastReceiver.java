package com.example.notificationsandbroadcastrecievers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.Toast;

public class PowerBroadcastReceiver extends BroadcastReceiver {

    ImageView img;
    public static final String CUSTOM_BROADCAST = "AnyUniqueStringCanBeGivenHere";

    public PowerBroadcastReceiver(ImageView imageView) {
        this.img = imageView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        switch (intent.getAction())
        {
            case Intent.ACTION_POWER_CONNECTED:
                img.setImageResource(R.drawable.ic_baseline_battery_charging_full_24);
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                img.setImageResource(R.drawable.ic_baseline_battery_alert_24);
                break;
            case CUSTOM_BROADCAST:
                Toast.makeText(context, "RECEIVED", Toast.LENGTH_SHORT).show();
                break;

        }

    }
}
