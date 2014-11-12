package com.vaby.assignday2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FactorialActivity extends Activity
{
	TextView textViewNum;
	Button buttonOnCalculate,buttonBack;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		setContentView(R.layout.factorialactivity);
		super.onCreate(savedInstanceState);
		
		textViewNum=(TextView)findViewById(R.id.textView1);
		buttonOnCalculate=(Button)findViewById(R.id.button1);
		buttonBack=(Button)findViewById(R.id.button2);
		
		Intent intent = getIntent();
		final int n = intent.getIntExtra("num",0);

		textViewNum.setText(n+"");
		
		
		
		buttonOnCalculate.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				int c=1;
				for(int i=1;i<=n;i++)
				{
					 c = c*i;
				}
				Intent inRes= new Intent();
				inRes.putExtra("fact",c);
				setResult(1,inRes);
				
				Toast t= Toast.makeText(FactorialActivity.this,""+c, Toast.LENGTH_SHORT);
				t.show();
			}			
		});
		
		buttonBack.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				finish();
			}
		});
		
	}
}
