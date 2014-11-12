package com.vaby.alaramservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service 
{
	@Override
	public void onCreate()
	{
		super.onCreate();
		Toast.makeText(this,"Service created",4).show();
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
		int n = intent.getIntExtra("num",0);
		Toast.makeText(this, "Started :"+n,5).show();
		
		return super.onStartCommand(intent, flags, startId);
	}
	@Override
	public IBinder onBind(Intent intent)
	{
		
		return null;
	}

}
