package com.vaby.dynamicui;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

@SuppressLint("NewApi")
public class MainActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		LinearLayout linear = new LinearLayout(MainActivity.this);
		
		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		linear.setLayoutParams(params);
		
		TextView textView = new TextView(this);
		LayoutParams params1 = new LayoutParams(120,50);
		textView.setLayoutParams(params1);
		textView.setText("Welcome");
		
		Button button1 = new Button(this);
		LayoutParams params2 = new LayoutParams(100,50);
		button1.setLayoutParams(params2);
		button1.setText("Go");
		
	//	LinearLayout = VERTICAL;
		linear.addView(textView);
		linear.addView(button1);
		
		setContentView(linear);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
