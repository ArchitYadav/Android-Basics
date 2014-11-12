package com.vaby.autocompletetextdemo;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	AutoCompleteTextView autoText;
	ArrayList<String> listCity = new ArrayList<String>();
	ArrayAdapter<String> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		autoText =(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
		
		listCity.add("Pune");
		listCity.add("Mumbai");
		listCity.add("Delhi");
		listCity.add("Calcutta");
		listCity.add("Chennai");
		listCity.add("Bhopal");
		listCity.add("Patna");
		listCity.add("Gandhi Nagar");
		listCity.add("Ahemdabad");
		listCity.add("Jaipur");
		listCity.add("Panjim");
		listCity.add("Agartala");
		listCity.add("Gwalior");
		listCity.add("Dehradun");
		listCity.add("Dhaka");
	
		adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,listCity);
		autoText.setAdapter(adapter);
		
		autoText.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				autoText.showDropDown();
			}
		});
		
		autoText.setOnItemClickListener(new OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
				String city =adapter.getItem(arg2);
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this,"Selected:"+city,6).show();
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
