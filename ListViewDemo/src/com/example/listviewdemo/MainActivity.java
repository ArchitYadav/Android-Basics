package com.example.listviewdemo;

import java.util.ArrayList;

import android.os.Bundle;
import android.R.string;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity
{

	ListView listViewCity;
	ArrayList<String> listCities = new ArrayList<String>();
	
	ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		listViewCity =(ListView)findViewById(R.id.listView1);
		
		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listCities);
		
		listCities.add("Gwalior");
		listCities.add("Eta");
		listCities.add("Pune");
		listCities.add("Dehradun");
		listCities.add("Varanasi");
		listCities.add("Delhi");
		listCities.add("Chennai");
		listCities.add("Aundh");
		listCities.add("Pimpri");
		listCities.add("Sangvi");
		listViewCity.setAdapter(adapter);
	
		listViewCity.setOnItemClickListener(new OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3)
			{
				String city = listCities.get(arg2); 
				Toast.makeText(MainActivity.this,city,Toast.LENGTH_SHORT).show();
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
