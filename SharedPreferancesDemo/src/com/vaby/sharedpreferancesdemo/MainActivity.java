package com.vaby.sharedpreferancesdemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText editEmail;
	Button buttonLogin,buttonSetting;
	RelativeLayout relative;
	String email="";
	int color=-1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editEmail=(EditText)findViewById(R.id.editText1);
		buttonLogin=(Button)findViewById(R.id.button1);
		buttonSetting=(Button)findViewById(R.id.button2);
		relative=(RelativeLayout)findViewById(R.id.relative);
		
		buttonLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				String newEmail=editEmail.getText().toString();
				if(email.equals(null))
				{
					Toast.makeText(MainActivity.this,"open settings",Toast.LENGTH_SHORT ).show();
				}
				else
				{
					if(email.equalsIgnoreCase(newEmail))
					{
						Intent intent=new Intent(MainActivity.this, HomeActivity.class);
						startActivity(intent);
					}
					else
					{
						Toast.makeText(MainActivity.this,"email addres dont match",Toast.LENGTH_SHORT ).show();
					}
				}
				
			}
		});
		buttonSetting.setOnClickListener(new OnClickListener()
		{			
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(MainActivity.this,SettingsActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
	
		
		super.onStart();
		//---------------get data from sharedpref
		SharedPreferences sp=getSharedPreferences("setting",MODE_PRIVATE);
		color=sp.getInt("themeColor", -1);
		email=sp.getString("userEmail", null);
		
		if(color!=-1)
		{
		switch (color) {
		case 0:
			relative.setBackgroundColor(Color.RED);
			
			break;
			
		case 1:
			relative.setBackgroundColor(Color.GREEN);
			
			break;
			
		case 2:
			relative.setBackgroundColor(Color.BLUE);
			
			break;
		case 3:
			relative.setBackgroundColor(Color.YELLOW);
			
			break;
			
		default:
			break;
		}	
		}
		
		//---------------------------------------
	
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
