package com.vaby.contentproviderdemo;

import java.lang.reflect.Array;
import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	ListView listView;
	String names[]={"Contacts","Emails","Names","Call log","SMS","Gallary","Browser Data"};
	ArrayAdapter< String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView =(ListView)findViewById(R.id.listView1);
		adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,names);
		
		listView.setAdapter(adapter);
		
		listView.setOnItemClickListener(new OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3)
			{			
				switch (arg2) 
				{
				case 0:
						Intent intent1 = new Intent(MainActivity.this,PhoneNumberActivity.class);
						startActivity(intent1);
				break;
				
				case 2:
						Intent intent = new Intent(MainActivity.this,ListNameActivity.class);
						startActivity(intent);
				break;
				

				case 1:
						Intent intent2 = new Intent(MainActivity.this,EmailActivity.class);
						startActivity(intent2);
				break;
				
				case 3:
					Intent intent3 = new Intent(MainActivity.this,CallLogActivity.class);
					startActivity(intent3);
			break;
			
				case 4:
					Intent intent4 = new Intent(MainActivity.this,SMSActivity.class);
					startActivity(intent4);
			break;

					default:
					break;
				}
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
