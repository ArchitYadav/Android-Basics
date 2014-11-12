package com.vaby.activitylifedemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MyActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Toast.makeText(this,"Oncreate...", Toast.LENGTH_LONG).show();
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		Toast.makeText(this,"OnStart...", Toast.LENGTH_LONG).show();
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Toast.makeText(this,"OnRsume...", Toast.LENGTH_LONG).show();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Toast.makeText(this,"OnPause...", Toast.LENGTH_LONG).show();
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Toast.makeText(this,"OnStop...", Toast.LENGTH_LONG).show();
	
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Toast.makeText(this,"OnDistroy...", Toast.LENGTH_LONG).show();
	}
}
