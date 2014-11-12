package com.vaby.notificationdemo;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity
{
	EditText editText;
	Button buttonGo;
	NotificationManager nManager;
	int i=1;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editText = (EditText)findViewById(R.id.editText1);
		buttonGo = (Button)findViewById(R.id.button1);
	
		nManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		buttonGo.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				String message = editText.getText().toString();
				String title = "Some Remainder";
				String ticker = "Message $ you";
				long time = System.currentTimeMillis();
				
				//Creating Pending Intent
				Intent intent = new Intent(MainActivity.this,NextActivity.class);
				
				PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this, 101, intent, PendingIntent.FLAG_UPDATE_CURRENT);
				// flag_on_Shot  = intent can only be used once by the other application 
			
				
				//notification creation
				Notification notice = new Notification(R.drawable.ic_launcher,ticker,time);
				notice.setLatestEventInfo(MainActivity.this, title,message, pIntent);
				nManager.notify(i++,notice);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
