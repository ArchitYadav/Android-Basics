package com.vaby.assignday3;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

	Spinner colourSpinner;
	TextView textView1;
	String colour[]={"Red","Green","Blue"};
	
	ArrayAdapter<String> stringAdapter; 
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		colourSpinner=(Spinner)findViewById(R.id.spinner1);
		textView1=(TextView)findViewById(R.id.textView1);
		stringAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,colour);
		colourSpinner.setAdapter(stringAdapter);
		
		colourSpinner.setOnItemSelectedListener(new OnItemSelectedListener()
		{

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3)
			{
				String s2 = stringAdapter.getItem(arg2);
				
				if(s2.equals("Red"))
				{
					textView1.setBackgroundColor(Color.RED);
				}
				if(s2.equals("Green"))
				{
					textView1.setBackgroundColor(Color.GREEN);
				}
				if(s2.equals("Blue"))
				{
					textView1.setBackgroundColor(Color.BLUE);	
				}
				
			}
			
			

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
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
