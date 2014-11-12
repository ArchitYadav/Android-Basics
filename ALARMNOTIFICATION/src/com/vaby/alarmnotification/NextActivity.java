package com.vaby.alarmnotification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

public class NextActivity extends Service
{
	NotificationManager nManager;
		
	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
		nManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);	
		String title = "Remainder";
		String ticker = "Message $ you";
		long time = intent.getIntExtra("time",0);
		String message=intent.getStringExtra("text");
		PendingIntent nPending = PendingIntent.getActivity(NextActivity.this, 101,intent, PendingIntent.FLAG_ONE_SHOT);
		
		NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		Notification notice = new Notification(R.drawable.ic_launcher,ticker,time);
		notice.setLatestEventInfo(NextActivity.this, title,message,nPending);
		nManager.notify(1,notice);
		Toast.makeText(this,"Notification",5).show();
				
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
