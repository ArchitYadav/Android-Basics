package com.vaby.assignday2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	EditText editNum;
	Button buttonCude,buttonFactorial;
	TextView textView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
	editNum = (EditText)findViewById(R.id.editText1);
	buttonCude = (Button)findViewById(R.id.button1);
	buttonFactorial = (Button)findViewById(R.id.button2);
	textView = (TextView)findViewById(R.id.textView1);
	
	buttonCude.setOnClickListener(new OnClickListener()
	{
		@Override
		public void onClick(View v)
		{
			int n=Integer.parseInt(editNum.getText().toString());

			Intent intent = new Intent(MainActivity.this,CubeActivity.class);
			intent.putExtra("num",n);
			
			startActivityForResult(intent, 101);
			
		}
	});
	
	buttonFactorial.setOnClickListener(new OnClickListener()
	{
		@Override
		public void onClick(View v)
		{
			int n=Integer.parseInt(editNum.getText().toString());
			Intent intent = new Intent(MainActivity.this,FactorialActivity.class);
			intent.putExtra("num",n);
			
			startActivityForResult(intent, 102);			
		}
	});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		
		if(requestCode == 101)
		{
			int c = data.getIntExtra("cube", 0);
			textView.setText("cube:"+c);
		}
		
		if(requestCode == 102)
		{
			int c = data.getIntExtra("fact", 0);
			textView.setText("fact:"+c);
		}
	}

}
