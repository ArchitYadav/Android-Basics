package com.vaby.multipleactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity 
{
	TextView textViewName,textViewAge;
	Button buttonVote,buttonBack;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secondeactivity);
	
		textViewName = (TextView)findViewById(R.id.textView1);
		textViewAge = (TextView)findViewById(R.id.textView2);
		buttonVote = (Button)findViewById(R.id.button1);
		buttonBack = (Button)findViewById(R.id.button2);
	
		Intent intent = getIntent();
		String n = intent.getStringExtra("name");
		final int a = intent.getIntExtra("age", 0);
		
		textViewName.setText(n);
		textViewAge.setText(a+""); //as a is int convert it into string
		
		buttonVote.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if(a >= 18)
				{
					Toast t= Toast.makeText(SecondActivity.this,"Eligible for voting", Toast.LENGTH_LONG);
					t.show();
				}
				else
				{
					Toast t= Toast.makeText(SecondActivity.this,"Not Eligible for voting", Toast.LENGTH_LONG);
					t.show();
				}
			}
		});
		
		buttonBack.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		}
}
