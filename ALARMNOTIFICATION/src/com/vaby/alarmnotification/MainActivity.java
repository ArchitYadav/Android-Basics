package com.vaby.alarmnotification;

import java.util.Calendar;

import com.vaby.alarmnotification.R.id;

import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends Activity {

	Button buttonSet,buttonSelect;
	EditText editRemaind;
	TextView textView; 
	AlarmManager alaram;
	String str="";
	long timeToExecute;
	int month,year,hrs,min,date;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		buttonSet = (Button)findViewById(R.id.button2);
		buttonSelect = (Button)findViewById(R.id.button1);
		editRemaind = (EditText)findViewById(R.id.editText1);
		textView = (TextView)findViewById(R.id.textView2);
		
		alaram = (AlarmManager) getSystemService(ALARM_SERVICE);
		
		
		buttonSet.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				String message = editRemaind.getText().toString();
				Intent intent = new Intent(MainActivity.this,NextActivity.class);
				intent.putExtra("text",message);
				intent.putExtra("time", timeToExecute);
				PendingIntent nPending = PendingIntent.getActivity(MainActivity.this, 101, intent, PendingIntent.FLAG_ONE_SHOT);
				alaram.setRepeating(AlarmManager.RTC_WAKEUP, timeToExecute, 6000, nPending);
				
			}
		});
	
		buttonSelect.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				/*Intent intent = new Intent(MainActivity.this,MyService.class);
				PendingIntent pIntent = PendingIntent.getService(MainActivity.this,101, intent,PendingIntent.FLAG_UPDATE_CURRENT);
				
				alaram.cancel(pIntent);
				*/
				
				final Dialog d = new Dialog(MainActivity.this);
				d.setTitle("Pick Date and Time");
				d.setContentView(R.layout.datetime);
				
				final DatePicker picker = (DatePicker) d.findViewById(R.id.datePicker1);
				final TimePicker tPicker = (TimePicker)d.findViewById(R.id.timePicker1);
				Button buttonOk = (Button)d.findViewById(R.id.button1);
				
				buttonOk.setOnClickListener(new OnClickListener()
				{
				
					@Override
					public void onClick(View v)
					{
						year = picker.getYear();
						month = picker.getMonth();
						date = picker.getDayOfMonth();
						
						hrs = tPicker.getCurrentHour();
						min = tPicker.getCurrentMinute();
						
						Calendar cal=Calendar.getInstance();
						cal.set(year,month,date,hrs,min);
						timeToExecute = cal.getTimeInMillis();
						str = date+"-"+month+"-"+year+"  "+hrs+":"+min;
						textView.setText(str);
						d.dismiss();
					}
				});	
				d.show();
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
