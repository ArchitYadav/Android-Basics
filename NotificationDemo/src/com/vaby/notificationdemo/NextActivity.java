package com.vaby.notificationdemo;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;

public class NextActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.next);
		
		//NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		//nm.cancelAll();
	}
}
