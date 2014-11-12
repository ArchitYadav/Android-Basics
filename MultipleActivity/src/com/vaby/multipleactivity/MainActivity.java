package com.vaby.multipleactivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText editName,editAge;
	Button buttonSend; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		editName = (EditText)findViewById(R.id.editText1);
		editAge = (EditText)findViewById(R.id.editText2);
		buttonSend = (Button)findViewById(R.id.button1);
		
		buttonSend.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				String name=editName.getText().toString();
				int age = Integer.parseInt(editAge.getText().toString());
				
				Intent intent = new Intent(MainActivity.this,SecondActivity.class);
				
				intent.putExtra("name",name);
				intent.putExtra("age",age);
				
				
				startActivity(intent);  //... Given to OS
			}
		});
		
	}
	
	@Override
	protected void onStart()
	{
		super.onResume();
		editName.setText("");
		editAge.setText("");
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
