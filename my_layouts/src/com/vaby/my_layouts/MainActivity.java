package com.vaby.my_layouts;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	Button green,blue;
	LinearLayout linear;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.flayout);
		
		green=(Button)findViewById(R.id.buttongreen);
		blue=(Button)findViewById(R.id.buttonblue);
	
		blue.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View v) {
				
				linear.setBackgroundColor(Color.BLUE);
			}
		});
		
		green.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View v) {
				
				linear.setBackgroundColor(Color.GREEN);
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
