package com.vaby.assignday3_2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends Activity {

	Spinner statesSpinner,citySpinner;
	Button buttonGo;
	
	String states[]={"Maharashtra","Uttarakhand","Tamilnadu"};
	//String cities[]={"Pune","Mumbai","Nagpur","Dehradun","Haridwar","Rorkee","Chennai","Madurai","Kanyakumari"};
	String cityM[]={"Pune","Mumbai","Nagpur"};
	String cityU[]={"Dehradun","Haridwar","Rorkee"};
	String cityT[]={"Chennai","Madurai","Kanyakumari"};
	ArrayAdapter<String> stateAdapter,cityMAdapter,cityUAdapter,cityTAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		statesSpinner=(Spinner)findViewById(R.id.spinner1);
		citySpinner=(Spinner)findViewById(R.id.spinner2);
		buttonGo=(Button) findViewById(R.id.button1);
		
		stateAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item ,states);
		cityMAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,cityM);
		cityUAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,cityU);
		cityTAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,cityT);
		statesSpinner.setAdapter(stateAdapter);
		//citySpinner.setAdapter(cityAdapter);
	
		statesSpinner.setOnItemSelectedListener(new OnItemSelectedListener()
		{

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3)
			{
				String s2 = stateAdapter.getItem(arg2);
				if(s2.equals("Maharashtra"))
				{
					citySpinner.setAdapter(cityMAdapter);
				}
				
				if(s2.equals("Uttarakhand"))
				{
					citySpinner.setAdapter(cityUAdapter);
				}
			
				if(s2.equals("Tamilnadu"))
				{
					citySpinner.setAdapter(cityTAdapter);
				}
						
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		buttonGo.setOnClickListener(new OnClickListener()
		{			
			@Override
			public void onClick(View v) 
			{
				String city = citySpinner.getSelectedItem().toString();

				Intent intent = new Intent(MainActivity.this,Activity2.class);
				intent.putExtra("city",city);
				
				startActivity(intent);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
