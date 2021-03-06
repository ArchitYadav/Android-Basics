package com.vaby.alaramservice;

import java.util.Calendar;

import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ScheduleAlarmActivity extends Activity {

	Button buttonSet,buttonCancel;
	EditText editData;
	AlarmManager alaram;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		buttonSet = (Button)findViewById(R.id.button1);
		buttonCancel = (Button)findViewById(R.id.button2);
		editData = (EditText)findViewById(R.id.editText1);
		
		alaram = (AlarmManager) getSystemService(ALARM_SERVICE);
		
		buttonSet.setOnClickListener(new OnClickListener()
		{		
			@Override
			public void onClick(View v)
			{
				//20-5-2014 10.30am
				Calendar cal=Calendar.getInstance();
				cal.set(2014,04,19,7,36,40);
				
				long timeToExecute =cal.getTimeInMillis();
				
				Intent intent = new Intent(ScheduleAlarmActivity.this,MyService.class);
				//get number and store in services intent
				int n=Integer.parseInt(editData.getText().toString());
				intent.putExtra("num", n);
				PendingIntent pIntent = PendingIntent.getService(ScheduleAlarmActivity.this,101, intent,PendingIntent.FLAG_UPDATE_CURRENT);
				
				//alaram.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, timeToExecute,pIntent);				
			alaram.setRepeating(AlarmManager.RTC_WAKEUP, timeToExecute, 6000, pIntent);
			}
		});
		buttonCancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(ScheduleAlarmActivity.this,MyService.class);
				PendingIntent pIntent = PendingIntent.getService(ScheduleAlarmActivity.this,101, intent,PendingIntent.FLAG_UPDATE_CURRENT);
				
				alaram.cancel(pIntent);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
