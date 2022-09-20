package com.example.notificationsandbroadcastrecievers;

import android.app.NotificationManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class SecondActivity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        imageView = findViewById(R.id.imageView);

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);

        registerReceiver(new PowerBroadcastReceiver(imageView), filter);

        IntentFilter filter2 = new IntentFilter(PowerBroadcastReceiver.CUSTOM_BROADCAST);
        //LocalBroadcastManager.getInstance(this).registerReceiver(new PowerBroadcastReceiver(imageView), filter2);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(new PowerBroadcastReceiver(imageView));
        //LocalBroadcastManager.getInstance(this).unregisterReceiver(new PowerBroadcastReceiver(imageView));

    }

    public void sendCustomBroadcast(View view) {
        /*LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(PowerBroadcastReceiver.CUSTOM_BROADCAST));*/
        sendBroadcast(new Intent(PowerBroadcastReceiver.CUSTOM_BROADCAST));
    }
}
