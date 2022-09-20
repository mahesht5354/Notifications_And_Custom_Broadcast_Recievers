package com.example.notificationsandbroadcastrecievers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public int NOTIFICATION_ID = 44;
    public int PENDING_INTENT_CODE = 47;
    private NotificationManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public void sendNotification(View view) {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel channel = new NotificationChannel("raj","Naresh Tech", NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "raj");
        builder.setSmallIcon(R.drawable.ic_baseline_add_home_work_24);
        builder.setContentTitle("A Sample Notification");
        builder.setContentText("This is the small describtion of the notification");
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);

        Intent i = new Intent(this, MainActivity.class);
        PendingIntent pi =  PendingIntent.getActivity(this, PENDING_INTENT_CODE, i, PendingIntent.FLAG_IMMUTABLE);
        builder.setContentIntent(pi);
        builder.setAutoCancel(true);

        Bitmap image = BitmapFactory.decodeResource(getResources(),R.drawable.downloading);
        builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(image));
        //builder.setStyle(new NotificationCompat.BigTextStyle().bigText("Any Large text can be written"));
        builder.addAction(R.drawable.ic_baseline_add_home_work_24,"Reply", pi);
        builder.addAction(R.drawable.ic_baseline_add_home_work_24,"Action", pi);



        manager.notify(NOTIFICATION_ID, builder.build());

    }

    public void cancelNotification(View view) {
        //manager.cancelAll;
        manager.cancel(NOTIFICATION_ID);

    }

    public void goToBroadcastReciever(View view) {

        Intent i = new Intent(this, SecondActivity.class);
        startActivity(i);

    }
}