package com.vaby.servicedemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {
	Button buttonStart,buttonStop; 
	EditText editText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		buttonStart = (Button)findViewById(R.id.button1);
		buttonStop = (Button)findViewById(R.id.button2);
		editText = (EditText)findViewById(R.id.editText1);	
		
	buttonStart.setOnClickListener(new OnClickListener()
	{		
		@Override
		public void onClick(View v)
		{
			String data = editText.getText().toString();
			Intent intent = new Intent(MainActivity.this,MyService.class);
			intent.putExtra("data", data);
			startService(intent);
		}
	});
	
	buttonStop.setOnClickListener(new OnClickListener()
	{
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(MainActivity.this,MyService.class);
			stopService(intent);	
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
