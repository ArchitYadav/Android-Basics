package com.vaby.sharedpreferancesdemo;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends Activity
{
	TextView text;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		text=(TextView)findViewById(R.id.textView2);
		
		SharedPreferences sp=getSharedPreferences("setting",MODE_PRIVATE);
		
		String email=sp.getString("userEmail", null);
		text.setText(email+"");
		
	
	}
}
