package com.vaby.assignday3_2;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends Activity
{
	Button backButton;
	TextView textView1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity2);
		backButton=(Button)findViewById(R.id.button1);
		textView1=(TextView)findViewById(R.id.textView2);
		
		Intent intent = getIntent();
		String n = intent.getStringExtra("city");
		textView1.setText("City:"+n);
	
	backButton.setOnClickListener(new OnClickListener()
	{
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			finish();
		}
	});
	}
	
	
}
