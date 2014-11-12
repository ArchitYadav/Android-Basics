package com.vaby.spinnerdemo;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

	Spinner studentSpinner;
	String arrayNames[]={"Ajay","Ram","Rohan","Papa","Sumit","Raj","Divya","Baba","Mama"};
	ArrayAdapter<String> adapter;  // adapter to connect data with spinner
 	Button showButton;
	TextView names; 
 	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		names = (TextView) findViewById(R.id.textView1);
		showButton=(Button)findViewById(R.id.button1);
		studentSpinner=(Spinner)findViewById(R.id.spinner1);
		//adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,arrayNames); 
		//2nd argument is already defined text view in adroid
		adapter = new ArrayAdapter<String>(this,R.layout.item_view,arrayNames);
		
		studentSpinner.setAdapter(adapter);
		showButton.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				String s =(String)studentSpinner.getSelectedItem(); 
				names.setText(s);
			}
		
		});
		
		studentSpinner.setOnItemSelectedListener(new OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3)
			{
				//String s = arrayNames[arg2];
				String s2 = adapter.getItem(arg2); //another way of doing it
				names.setText(s2);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0)
			{
				
				
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
