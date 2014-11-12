package com.vaby.broadcastapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText editData;
	Button buttonSend;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editData = (EditText)findViewById(R.id.editText1);
		buttonSend = (Button)findViewById(R.id.button1);
		
		buttonSend.setOnClickListener(new OnClickListener()
		{			
			@Override
			public void onClick(View v)
			{
				String d = editData.getText().toString();
				Intent intent = new Intent();
				intent.putExtra("Data",d);
				intent.setAction("com.vaby.broadcastapp.MY_ACTION");
				
				sendBroadcast(intent);    	// intent --> OS
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
